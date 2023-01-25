package com.projeto.gerenciador.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.projeto.gerenciador.entities.Endereco;
import com.projeto.gerenciador.entities.Pessoa;
import com.projeto.gerenciador.repository.EnderecoRepository;
import com.projeto.gerenciador.repository.PessoaRepository;
import com.projeto.gerenciador.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	@Autowired
	EnderecoRepository enderecoRepository;


	public Pessoa postar(Pessoa dto) {
		repository.save(dto);
		return dto;
	}

	//Buscando todos id da pessoa

	public ResponseEntity<?> atualizarUsuario(long id, Pessoa pessoa) {
		try {
			return repository.findById(id).map(record -> {
				record.setNmPessoa(pessoa.getNmPessoa());
				record.setDtNascimento(pessoa.getDtNascimento());
				Pessoa update = repository.save(record);

				return new ResponseEntity(update, HttpStatus.OK);
			}).orElse(ResponseEntity.badRequest()
					.body("Não foi possível atualizar o pessoa. Por favor, tente novamente."));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Erro não identificado", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	public Pessoa buscarPorIdDaPessoa(Long id) {
		Optional<Pessoa> record = this.repository.findById(id);
		Optional<Pessoa> obj = repository.findById(id);
		Pessoa entity = obj.orElseThrow(() -> new ResourceNotFoundException("Pessoa não existe"));
		return entity;
	}
	//Buscando todos id da pessoa
	public List<Pessoa> buscarTodospessoa() {
			List<Pessoa> list = repository.findAll();
			return (list);
		}
	public Endereco enderecoById(Long id) {
		Optional<Endereco> obj = enderecoRepository.findById(id);
		Endereco entity = obj.orElseThrow(() -> new ResourceNotFoundException("Pessoa Não encontrado"));
		return entity;
	}

	public ResponseEntity<?> excluirUsuario(long id) {
		return repository.findById(id).map(record -> {
			repository.deleteById(id);

			return ResponseEntity.ok().body("Usuario do ID " + id + " foi deletado com sucesso!");
		}).orElse(ResponseEntity.notFound().build());
	}

	}



