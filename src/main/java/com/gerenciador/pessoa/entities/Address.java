package com.gerenciador.pessoa.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


@Entity
@Table(name = "tb_address")
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Cep;

    private String logradouro;

    private Integer number;
    private Boolean main;

    @ManyToOne
    @JoinColumn(name = "people_id")
    @JsonIgnore
    private People people;

    public Address() {
    }

    public Address(Long id, String  Cep, String logradouro, Integer number,
                   Boolean main, People people) {
        this.id = id;
        this.Cep = Cep;
        this.logradouro= logradouro;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((Cep == null) ? 0 : Cep.hashCode());
        result = prime * result + ((number == null) ? 0 : number.hashCode());
        result = prime * result + ((Cep == null) ? 0 : Cep.hashCode());
        result = prime * result + ((main == null) ? 0 : main.hashCode());
        result = prime * result + ((people == null) ? 0 : people.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Address other = (Address) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (Cep == null) {
            if (other.Cep != null)
                return false;
        } else if (!Cep.equals(other.Cep))
            return false;
        if (logradouro == null) {
            if (other.logradouro != null)
                return false;
        } else if (!logradouro.equals(other.logradouro))
            return false;
        if (number == null) {
            if (other.number != null)
                return false;
        } else if (!number.equals(other.number))
            return false;
        if (main == null) {
            if (other.main != null)
                return false;
        } else if (!main.equals(other.main))
            return false;
        if (people == null) {
            if (other.people != null)
                return false;
        } else if (!people.equals(other.people))
            return false;
        return true;
    }
}
