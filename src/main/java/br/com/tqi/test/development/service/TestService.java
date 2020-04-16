package br.com.tqi.test.development.service;

import br.com.tqi.test.development.ViaCepClient;
import br.com.tqi.test.development.entity.AddressEntity;
import br.com.tqi.test.development.entity.ClientEntity;
import br.com.tqi.test.development.exception.ClientException;
import br.com.tqi.test.development.exception.EnderecoException;
import br.com.tqi.test.development.exception.NotFoundException;
import br.com.tqi.test.development.model.dto.AddressDTO;
import br.com.tqi.test.development.model.dto.ClientDTO;
import br.com.tqi.test.development.repository.AddressRepository;
import br.com.tqi.test.development.repository.ClientRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TestService {

    private ClientRepository clientRepository;

    private AddressRepository addressRepository;

    private ViaCepClient viaCepClient;

    @Autowired
    public TestService(ClientRepository clientRepository, AddressRepository addressRepository, ViaCepClient viaCepClient) {
        this.clientRepository = clientRepository;
        this.addressRepository = addressRepository;
        this.viaCepClient = viaCepClient;
    }

    public List<ClientDTO> getClients() {
        return clientRepository.findAll().stream()
                .map(ClientDTO::new)
                .collect(Collectors.toList());
    }

    public ClientDTO getClient(Long id) throws NotFoundException {
        Optional<ClientEntity> client = clientRepository.findById(id);
        if(client.isPresent()) {
            return new ClientDTO(client.get());
        } else {
            throw new NotFoundException("Cliente não encontrado");
        }
    }

    public ClientDTO saveNewClient(ClientDTO clientDTO) {
        ClientEntity clientEntity = clientRepository.save(new ClientEntity(clientDTO));
        return new ClientDTO(clientEntity);
    }

    public void changeClientAddress(Long idClient, AddressDTO address) throws EnderecoException {
        AddressEntity actualAddress = null;
        Optional<ClientEntity> clientEntity = clientRepository.findById(idClient);

        if(clientEntity.isPresent() && clientEntity.get().getAddressEntity() != null) {
            actualAddress = addressRepository.findById(clientEntity.get().getAddressEntity().getId()).get();
        }

        if (actualAddress != null) {
            addressRepository.save(new AddressEntity(address));
        } else {
            throw new EnderecoException("Erro ao tentar editar endereço!");
        }
    }

    public AddressEntity getAddressByCep(String cep) throws JsonProcessingException, ClientException {
        ObjectNode objectNode = viaCepClient.getAddressByCep(cep);

        AddressEntity addressEntity = new AddressEntity();

        if (objectNode.has("cep")) {
            addressEntity.setCep(objectNode.get("cep").toString().replace("\"", ""));
        }

        if (objectNode.has("logradouro")) {
            addressEntity.setEndereco(objectNode.get("logradouro").toString().replace("\"", ""));
        }

        if (objectNode.has("bairro")) {
            addressEntity.setBairro(objectNode.get("bairro").toString().replace("\"", ""));
        }

        if (objectNode.has("localidade")) {
            addressEntity.setCidade(objectNode.get("localidade").toString().replace("\"", ""));
        }

        if (objectNode.has("uf")) {
            addressEntity.setEstado(objectNode.get("uf").toString().replace("\"", ""));
        }

        addressEntity.setPais("Brasil");

        return addressEntity;
    }
}
