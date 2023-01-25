
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




