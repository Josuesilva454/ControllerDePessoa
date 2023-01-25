
# API REST para controle de uma lista de endereços por usuário

## Objetivo

* **Primeiro passo** deve ser a construção de um cadastro de pessoas, sendo obrigatório dados como: nome e data de nascimento. Construir a API em um banco de dados local

* **Segundo passo** é criar um cadastro de endereços, sendo obrigatório dados mínimos para cadastro como: logradouro, número e CEP, associando este endereço da pessoa.

* **Terceiro passo** é criar um endpoint que retornará um usuário com a lista de todos seus endereços cadastrados.

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


#Pessoa

Body da requisição:
{
"dtNascimento": "string",
"enderecoList": [
{
"cep": "string",
"idEndereco": 0,
"logradouro": "string",
"numero": 0
}
],
"idPessoa": 0,
"nmPessoa": "string"
}


Get/endereco/{id}/endereco: cria um endereço.

Poder informar qual endereço é o principal da pessoa.
{
"idEndereco": 1,
"cep": "35877-568",
"logradouro": "Rua Dinora Ferreira Messerder",
"numero": 125
}





#Endereço

Get/endereco/: cria um endereço.



POST/endereco/: cria um endereço.

{
"cep": "32557-560",
"idEndereco": 0,
"logradouro": "Rua Dinora Ferreira Messerder",
"numero": 130,
"pessoa": {
"dtNascimento": "04/06/1997",
"enderecoList": [
null
],
"idPessoa": 0,
"nmPessoa": "Josue"
}
}

Body da requisição:

{
"idEndereco": 1,
"cep": "32557-560",
"logradouro": "Rua Dinora Ferreira Messerder",
"numero": 130
}

PUT/endereco/{id}: Editar cria um endereço.

Mode:

{
"cep": "35877-568",
"idEndereco": 0,
"logradouro": "Rua Dinora Ferreira Messerder",
"numero": 125,
"pessoa": {
"dtNascimento": "05/08/1998",
"enderecoList": [
null
],
"idPessoa": 0,
"nmPessoa": "lucas"
}
}

Response body:
{
"idEndereco": 1,
"cep": "35877-568",
"logradouro": "Rua Dinora Ferreira Messerder",
"numero": 125
}









