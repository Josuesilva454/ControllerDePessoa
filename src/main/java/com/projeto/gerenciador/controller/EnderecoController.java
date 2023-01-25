package com.projeto.gerenciador.controller;

import java.net.URI;
import java.util.List;

import com.projeto.gerenciador.entities.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projeto.gerenciador.entities.Endereco;
import com.projeto.gerenciador.service.EnderecoService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoService service;


	@PostMapping
	public ResponseEntity<?> salvarEndereco(@RequestBody Endereco endereco) {
		return service.salvarEndereco(endereco);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping(value = "{id}")
	public ResponseEntity<?> atualizarEndereco(@PathVariable long id, @RequestBody Endereco endereco){
		return service.atualizarEndereco(id, endereco);
	}



}
