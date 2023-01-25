package com.projeto.gerenciador.service;

import java.util.List;
import java.util.Optional;

import com.projeto.gerenciador.entities.Endereco;
import com.projeto.gerenciador.entities.Pessoa;
import com.projeto.gerenciador.repository.EnderecoRepository;
import com.projeto.gerenciador.repository.PessoaRepository;
import com.projeto.gerenciador.service.exceptions.ResourceNotFoundException;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
	
	@Autowired
	EnderecoRepository repository;



	public ResponseEntity<?> salvarEndereco(Endereco endereco) {
		try {
			return new ResponseEntity<Endereco>(this.repository.save(endereco), HttpStatus.CREATED);
		} catch (JpaSystemException | GenericJDBCException | HttpMessageNotReadableException
				| DataIntegrityViolationException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(
					"Dados informados inválido! Verificar se os dados informados já foram cadastrados.",
					HttpStatus.BAD_REQUEST);
		}
	}
	
	public ResponseEntity<?> atualizarEndereco(long id, Endereco endereco) {
		try {
			return repository.findById(id).map(record -> {
				record.setCep(endereco.getCep());
				record.setLogradouro(endereco.getLogradouro());
				record.setNumero(endereco.getNumero());
				Endereco update = repository.save(record);

				return new ResponseEntity(update, HttpStatus.OK);
			}).orElse(ResponseEntity.badRequest().body("Não foi possível atualizar o pessoa. Por favor, tente novamente."));
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity("Erro não identificado", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

		
	}






