# Teste TQI

- API para cadastro de clientes


  	Cliente: {nome:"", cpf: "", sexo: "", endereco:{endereco: "", numero:"", complemento:"", cidade:"", estado:"", cep:"", pais:""}}


## Ajustes realizados

- Projeto organizado em pacotes seguindo modelagens tradicionais;
- Alteração no script da modelagem das tabelas;

### Entity
- A modelagem de dados foi alterada para que o id do endereço seja salvo na entidade client;
- Ajuste do relacionamento e persistência entre client e address para OneToOne cascade ALL;

### Service
- Ajuste no método saveNewClient, simplicando a persistência com a nova modelagem de dados;
- Alterações no método changeClientAddress, na forma como os dados são recuperados e editados, assim como tratamento de erros;
- Implementação dos métodos getClients e getClient que estavam injetando as classes repositories diretamente na camada controller;
- Ajuste no médodo getAddressByCep, passando a consulta a api viacep para a classe ViaCepClient

### Exception
- Implementação de classes para tratamento de exceções;

## Client
- Implementação da classe ViaCepClient para integração com a api ViaCep;
