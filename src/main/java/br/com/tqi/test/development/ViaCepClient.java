package br.com.tqi.test.development;

import br.com.tqi.test.development.exception.ClientException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepClient {

    private RestTemplate restTemplate;

    @Value("${client.api.url.viacep}")
    private String urlViaCep;

    @Autowired
    public ViaCepClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ObjectNode getAddressByCep(String cep) throws ClientException, JsonProcessingException {
        ResponseEntity<String> reAddress = restTemplate.getForEntity(urlViaCep + cep + "/json", String.class);
        if(reAddress.getBody() == null) {
            throw new ClientException("Erro ao tentar buscar dados de endereço");
        }
        return new ObjectMapper().readValue(reAddress.getBody(), ObjectNode.class);
    }

}
