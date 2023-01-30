package com.gerenciador.pessoa.services;

import com.gerenciador.pessoa.entities.People;
import com.gerenciador.pessoa.dtos.PeopleDTO;
import com.gerenciador.pessoa.exceptions.ResourceNotFoundException;
import com.gerenciador.pessoa.mappers.PeopleMapper;
import com.gerenciador.pessoa.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PeopleService {

    @Autowired
    private PeopleRepository repository;

    @Autowired
    private PeopleMapper mapper;


    public PeopleDTO insert(PeopleDTO dto) {
        People entity = mapper.dtoToEntity(dto);
        repository.save(entity);
        return mapper.entityToDTO(entity);
    }

    public PeopleDTO update(Long id, PeopleDTO dto) {
        try {
            People entity = mapper.dtoToEntity(dto);
            repository.save(entity);
            return mapper.entityToDTO(entity);
        } catch (EntityNotFoundException err) {
            throw new ResourceNotFoundException("Id não existem: " + id);
        }
    }

    public List<PeopleDTO> findAll() {
        List<People> list = repository.findAll();
        return mapper.entityListToDtoList(list);
    }

    public PeopleDTO findById(Long id) {
        Optional<People> obj = repository.findById(id);
        People entity = obj.orElseThrow(() -> new ResourceNotFoundException("Pessoa não existem"));
        return mapper.entityToDTO(entity);
    }
    }

