package com.gerenciador.pessoa.dtos;

import com.gerenciador.pessoa.entities.People;

import java.io.Serializable;

public class AddressRequestDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String Cep;
    private Integer number;
    private String logradouro;
    private People people;

    public AddressRequestDTO() {
    }

    public AddressRequestDTO(Long id, String Cep,String logradouro, Integer number, People people) {
        this.id = id;
        this.Cep = Cep;
        this.number = number;
        this.logradouro = logradouro;
        this.people = people;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return Cep;
    }

    public void setCep(String cep) {
        Cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }



    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }
}
