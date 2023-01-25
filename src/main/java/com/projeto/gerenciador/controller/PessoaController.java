package com.projeto.gerenciador.controller;

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

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService service;
	
	@GetMapping("/buscar")
	public ResponseEntity<?> buscarTodosUsuarios() {
		return service.buscarTodosUsuarios();
	}

	@GetMapping(value = "{id}")
	public ResponseEntity<?> buscarPorIdDoUsuario(@PathVariable Long id) {
		return service.buscarPorIdDoUsuario(id);
	}
	
	@PostMapping
	public Pessoa salvarUsuario(@RequestBody Pessoa pessoa) {
		return service.salvarUsuario(pessoa);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping(value = "{id}")
	public ResponseEntity<?> atualizarUsuario(@PathVariable long id, @RequestBody Pessoa pessoa){
			return service.atualizarUsuario(id, pessoa);
	}
	
	@DeleteMapping(path = { "{id}" })
	public ResponseEntity<?> excluirUsuario(@PathVariable long id) {
		return service.excluirUsuario(id);
	
	}
}
