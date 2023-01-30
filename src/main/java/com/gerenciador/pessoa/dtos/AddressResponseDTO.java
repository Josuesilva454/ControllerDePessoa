package com.gerenciador.pessoa.dtos;

import com.gerenciador.pessoa.entities.People;

import java.io.Serializable;

public class AddressResponseDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private People people;

    public AddressResponseDTO() {
    }

    public AddressResponseDTO(Long id, People people) {
        this.id = id;
        this.people = people;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }
}
