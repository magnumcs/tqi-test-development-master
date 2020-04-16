package br.com.tqi.test.development.model.dto;

import br.com.tqi.test.development.entity.AddressEntity;

import java.io.Serializable;

public class AddressDTO implements Serializable {

    private Long id;
    private String endereco;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String pais;
    private String cep;

    public AddressDTO() {
    }

    public AddressDTO(AddressEntity addressEntity) {
        this.id = addressEntity.getId();
        this.endereco = addressEntity.getEndereco();
        this.numero = addressEntity.getNumero();
        this.complemento = addressEntity.getComplemento();
        this.bairro = addressEntity.getBairro();
        this.cidade = addressEntity.getCidade();
        this.estado = addressEntity.getEstado();
        this.pais = addressEntity.getPais();
        this.cep = addressEntity.getCep();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}
