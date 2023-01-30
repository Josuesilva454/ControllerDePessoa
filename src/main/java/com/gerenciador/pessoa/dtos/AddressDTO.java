package com.gerenciador.pessoa.dtos;

import com.gerenciador.pessoa.entities.People;

import java.io.Serializable;

public class AddressDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String Cep;
    private Integer number;
    private String logradouro;
    private Boolean main;
    private People people;

    public AddressDTO() {
    }

    public AddressDTO(Long id, String Cep, String logradouro,Integer number, Boolean main, People people) {
        this.id = id;
        this.Cep = Cep;
        this.logradouro = logradouro;
        this.number = number;
        this.main = main;
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


    public Boolean getMain() {
        return main;
    }

    public void setMain(Boolean main) {
        this.main = main;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }
}