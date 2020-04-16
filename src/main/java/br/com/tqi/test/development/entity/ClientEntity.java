package br.com.tqi.test.development.entity;

import br.com.tqi.test.development.model.dto.ClientDTO;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CLIENT")
public class ClientEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sexo")
    private String sexo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address", referencedColumnName = "id")
    private AddressEntity addressEntity;

    public ClientEntity() {
        super();
    }

    public ClientEntity(ClientDTO clientEntity) {
        this.id = clientEntity.getId();
        this.cpf = clientEntity.getCpf();
        this.nome = clientEntity.getNome();
        this.sexo = clientEntity.getSexo();
        this.addressEntity = new AddressEntity(clientEntity.getAddress());
    }

    public ClientEntity(Long id) {
        this.id = id;
    }

    public ClientEntity(Long id, String cpf, String nome, String sexo, AddressEntity addressEntity) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.sexo = sexo;
        this.addressEntity = addressEntity;
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

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }
}
