package com.projeto.gerenciador.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Endereco implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEndereco;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_pessoa", foreignKey = @ForeignKey(name = "fk_endereco_pessoa"))
	@JsonBackReference
	private Pessoa pessoa;
	
	private String cep;
	private String logradouro;

	private int numero;
	
	
	public Endereco() {}
	
	public Endereco(Long idEndereco, Pessoa pessoa, String cep, String logradouro, int numero) {
		super();
		this.idEndereco = idEndereco;
		this.pessoa = pessoa;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
	}



	public Long getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
}
