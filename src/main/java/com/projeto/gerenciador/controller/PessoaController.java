package com.projeto.gerenciador.controller;

import com.projeto.gerenciador.entities.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.gerenciador.entities.Pessoa;
import com.projeto.gerenciador.service.PessoaService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService service;

	//Buscar todas Pessoa
	@GetMapping("/buscar")
	public ResponseEntity<List<Pessoa>>buscarTodospessoa( ) {
		List<Pessoa> list = service.buscarTodospessoa();
		return ResponseEntity.ok().body(list);
	}
	//Buscar todas Pessoa id da pessoa
	@GetMapping(value = "{id}")
	public ResponseEntity<Pessoa> buscarPorIdDaPessoa(@PathVariable Long id) {
		Pessoa dto = service.buscarPorIdDaPessoa(id);
		return ResponseEntity.ok().body(dto);


	}
	//Postar nome da pessoa
	@PostMapping
	public ResponseEntity<Pessoa> postar(@RequestBody @Valid Pessoa dto) {
		Pessoa peopleDto = service.postar(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(peopleDto.getIdPessoa())
				.toUri();
		return ResponseEntity.created(uri).body(peopleDto);
	}

	// Editar Pessoa
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping(value = "{id}")
	public ResponseEntity<?> atualizarUsuario(@PathVariable long id, @RequestBody Pessoa pessoa){
			return service.atualizarUsuario(id, pessoa);
	}
	// Pode informa endereco da pessoa
	@GetMapping(value = "/{id}/endereco")
	public ResponseEntity<Endereco> enderecoById(@PathVariable Long id) {
		Endereco entity = service.enderecoById(id);
		return ResponseEntity.ok().body(entity);
	}


	// Deteleta a pessoa
	@DeleteMapping(path = { "{id}" })
	public ResponseEntity<?> excluirUsuario(@PathVariable long id) {
		return service.excluirUsuario(id);
	
	}

}
