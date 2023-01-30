package com.gerenciador.pessoa.controllers;

import com.gerenciador.pessoa.dtos.AddressDTO;
import com.gerenciador.pessoa.dtos.AddressRequestDTO;
import com.gerenciador.pessoa.dtos.AddressResponseDTO;
import com.gerenciador.pessoa.dtos.PeopleDTO;
import com.gerenciador.pessoa.services.AddressServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/api")
public class AddressController {

    @Autowired
    private AddressServico service;

    @PostMapping(value = "/endereco")
    public ResponseEntity<AddressResponseDTO> insert(@RequestBody AddressRequestDTO dto, @RequestParam Long peopleId) {
        AddressResponseDTO addressDto = service.insert(dto, peopleId);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addressDto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(addressDto);

    }
    @PutMapping(value = "{id}")
    public ResponseEntity<AddressDTO> update(@PathVariable AddressDTO id, @RequestBody @Valid AddressDTO dto) {
        AddressDTO addressDTO = service.update(id, dto);
        return ResponseEntity.ok().body(addressDTO);
    }
    @PostMapping(value = "/principal")
    public ResponseEntity<AddressResponseDTO> setAddressMain(@RequestParam Long addressId) {
        AddressResponseDTO addressDto = service.setAddressMain(addressId);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addressDto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(addressDto);
    }
}


