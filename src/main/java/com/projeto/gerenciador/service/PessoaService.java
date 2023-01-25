package com.projeto.gerenciador.service;

import java.util.Collection;
import java.util.Optional;

import com.projeto.gerenciador.entities.Pessoa;
import com.projeto.gerenciador.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;


	public ResponseEntity<?> buscarPorIdDoUsuario(Long id) {
			Optional<Pessoa> record = this.repository.findById(id);

			if (record.orElseGet(() -> null) != null) {
				return new ResponseEntity<Pessoa>(record.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Pessoa não localizado. Tente novamente!", HttpStatus.BAD_REQUEST);
			}
		}

	public ResponseEntity<?> buscarTodosUsuarios() {
		try {
			Collection<Pessoa> lista = this.repository.findAll();
			return new ResponseEntity<Collection<Pessoa>>(lista, HttpStatus.OK);
		} catch (MethodArgumentTypeMismatchException | NumberFormatException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(
					"Não foi possível encontrar os dados. Verifique se o link digitado está correto.",
					HttpStatus.NOT_FOUND);
		}
	}

	public Pessoa salvarUsuario(Pessoa pessoa) {
		      repository.save(pessoa);
		return pessoa;

	}

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

	public ResponseEntity<?> excluirUsuario(long id) {
		return repository.findById(id).map(record -> {
			repository.deleteById(id);

			return ResponseEntity.ok().body("Usuario do ID " + id + " foi deletado com sucesso!");
		}).orElse(ResponseEntity.notFound().build());
	}

}
