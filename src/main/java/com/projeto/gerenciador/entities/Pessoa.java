package com.projeto.gerenciador.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity(name = "Pessoa")
@Table(name = "Pessoa")
public class Pessoa implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pessoa")
	private Long idPessoa;

	@Column(name = "nm_pessoa")
	private String nmPessoa;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "dt_nascimento")
	private LocalDate dtNascimento;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id_usuario", foreignKey = @ForeignKey(name = "fk_endereco_usuario"))
	@JsonManagedReference	
	private List<Endereco> enderecoList = new ArrayList<>();

	public void addEndereco(Endereco endereco) {
		enderecoList.add(endereco);
	}
	
	public void removerEndereco(Endereco endereco) {
		enderecoList.remove(endereco);
	}

	public Pessoa(Long idPessoa, String nmPessoa, String email, LocalDate dtNasc,
				  List<Endereco> enderecoList) {
		super();
		this.idPessoa = idPessoa;
		this.dtNascimento = dtNasc;
		this.enderecoList = enderecoList;
	}
	
	public Pessoa(){}

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idUsuario) {
		this.idPessoa = idUsuario;
	}

	public LocalDate getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(LocalDate dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getNmPessoa() {
		return nmPessoa;
	}

	public void setNmPessoa(String nmPessoa) {
		this.nmPessoa = nmPessoa;
	}

	public List<Endereco> getEnderecoList() {
		return enderecoList;
	}

	public void setEnderecoList(List<Endereco> enderecoList) {
		this.enderecoList = enderecoList;
	}
	
	
	

}
