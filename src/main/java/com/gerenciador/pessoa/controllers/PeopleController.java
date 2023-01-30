package com.gerenciador.pessoa.controllers;

import com.gerenciador.pessoa.dtos.PeopleDTO;
import com.gerenciador.pessoa.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/pessoa")
public class PeopleController {

    @Autowired
    private PeopleService service;


    @PostMapping
    public ResponseEntity<PeopleDTO> insert(@RequestBody @Valid PeopleDTO dto) {
        PeopleDTO peopleDto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(peopleDto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(peopleDto);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<PeopleDTO> update(@PathVariable Long id, @RequestBody @Valid PeopleDTO dto) {
         service.update(id, dto);
        return ResponseEntity.ok(dto);
    }

    @GetMapping()
    public ResponseEntity<List<PeopleDTO>> findAll() {
        List<PeopleDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PeopleDTO> findById(@PathVariable Long id) {
        PeopleDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }
}

