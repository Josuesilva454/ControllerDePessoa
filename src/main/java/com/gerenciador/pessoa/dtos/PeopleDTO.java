package com.gerenciador.pessoa.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;

public class PeopleDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "field cannot be empty")
    private String name;


    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    public PeopleDTO() {
    }

    public PeopleDTO(Long id, @NotBlank(message = "field cannot be empty") String name,

                    @NotBlank(message = "field cannot be empty") LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}