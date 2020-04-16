package br.com.tqi.test.development.model.dto;

import br.com.tqi.test.development.entity.ClientEntity;

import java.io.Serializable;

public class ClientDTO implements Serializable {
    private Long id;
    private String cpf;
    private String nome;
    private String sexo;
    private AddressDTO address;

    public ClientDTO() {
    }

    public ClientDTO(ClientEntity clientEntity) {
        this.id = clientEntity.getId();
        this.cpf = clientEntity.getCpf();
        this.nome = clientEntity.getNome();
        this.sexo = clientEntity.getSexo();
        this.address  = new AddressDTO(clientEntity.getAddressEntity());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }
}
