package br.com.tqi.test.development.controller;

import br.com.tqi.test.development.entity.AddressEntity;
import br.com.tqi.test.development.exception.ClientException;
import br.com.tqi.test.development.exception.EnderecoException;
import br.com.tqi.test.development.exception.NotFoundException;
import br.com.tqi.test.development.model.dto.AddressDTO;
import br.com.tqi.test.development.model.dto.ClientDTO;
import br.com.tqi.test.development.service.TestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test-tqi")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping(value = "/client")
    public ResponseEntity<List<ClientDTO>> getAllClient() {
        return ResponseEntity.ok(testService.getClients());
    }

    @GetMapping(value = "/client/{id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable("id") Long id) throws NotFoundException {
        return ResponseEntity.ok(testService.getClient(id));
    }

    @PostMapping(value = "/client", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDTO> saveNewClient(@RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok(testService.saveNewClient(clientDTO));
    }

    @PostMapping(value = "/client/change-address/{id}/")
    public ResponseEntity<Void> changeClientAddress(
            @PathVariable("id") Long id,
            @RequestBody AddressDTO address) throws EnderecoException {
        testService.changeClientAddress(id, address);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/address/{cep}")
    public ResponseEntity<AddressEntity> getAddressByCEP(@PathVariable("cep") String cep) throws JsonProcessingException, ClientException {
        return ResponseEntity.ok(testService.getAddressByCep(cep));
    }
}
