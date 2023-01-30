
# API REST para controle de uma lista de endereços por pessoa

## Objetivo

* **Primeiro passo** deve ser a construção de um cadastro de pessoas, sendo obrigatório dados como: nome e data de nascimento. Construir a API em um banco de dados local

* **Segundo passo** é criar um cadastro de endereços, sendo obrigatório dados mínimos para cadastro como: logradouro, número e CEP, associando este endereço da pessoa.

* **Terceiro passo** é criar um endpoint que retornará uma pessoa com a lista de todos seus endereços cadastrados.

Devemos construir 3 endpoints neste sistema, o cadastro da pessoa, o cadastro de endereços e a listagem dos endereços de uma pessoa específico.
\- Caso os cadastros estejam corretos, **é necessário** voltar o Status 201, caso haja erros de preenchimento de dados, o Status deve ser 400.
\- Caso a busca esteja correta, **é necessário** voltar o status 200, caso haja erro na busca, retornar o Status adequado e uma mensagem de erro amigável.

## Tecnologias Utilizadas:

* :computer: IntelliJ IDEA 
* :space_invader: Maven
* :heavy_check_mark: Spring boot 
* :black_circle: swagger ou postman
* :books: h2 banco de dados

## Qualidade do código
1.	Durante a implementação de uma nova funcionalidade de software solicitada, quais critérios você avalia e implementa para garantia de qualidade de software?

Após a implementação de uma nova funcionalidade, podemos utilizar testes funcionais como testes unitários e de integração, para garantir a qualidade do software e dos métodos/funcionalidades implementados. Também deve ser utilizado o conceito de TDD para um maior proveito dos testes.

2. Em qual etapa da implementação você considera a qualidade de software?

A qualidade de software deve ser considerada em todas as etapas de desenvolvimento do software.


### Pessoa
1. Criar uma pessoa:

POST/api/pessoa
Body da requisição:
```json
{
  "id": 0,
  "name": "lucas",
  "birthDate": "1996-05-09"
}
```
2. Editar uma pessoa:

Put/api/pessoa/1
Body da requisição:
```json
{
  "id": 1,
  "name": "João Vitor",
  "birthDate": "1998-04-08"
}
```
3. Consultar  pessoa:

Get/api/pessoa/1
Body da requisição:
```json
{
  "id": 1,
  "name": "João Vitor",
  "birthDate": "1998-04-08"
}
```

4. Listar todas pessoa:

Get/api/pessoa
Body da requisição:
```json
[
  {
    "id": 1,
    "name": "João Vitor",
    "birthDate": "1998-04-08"
  }
]
```


Get/endereco/{id}/endereco: cria um endereço.

Poder informar qual endereço é o principal da pessoa.
```json
{
"idEndereco": 1,
"cep": "35877-568",
"logradouro": "Rua Dinora Ferreira Messerder",
"numero": 125
}
```

### Endereço

Criar endereço para a pessoa

POST/api/endereco?peopleId=1 

Body da requisição:

```json
{
  "id": 0,
  "people": {
    "id": 1,
    "name": "João Vitor",
    "birthDate": "1998-04-08",
    "addresses": [
      {
        "id": 1,
        "logradouro": "Rua Dinorah Ferreira Messeder",
        "number": 125,
        "main": false,
        "cep": "32568-325"
      }
    ]
  }
}
```


Informar endereço da pessoa.

POST/api/principal?addressId=1


```json
{
  "id": 1,
  "people": {
    "id": 1,
    "name": "João Vitor",
    "birthDate": "1998-04-08",
    "addresses": [
      {
        "id": 1,
        "logradouro": "Rua Dinorah Ferreira Messeder",
        "number": 125,
        "main": true,
        "cep": "32568-325"
      }
    ]
  }
}
```








