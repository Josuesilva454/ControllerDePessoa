package com.gerenciador.pessoa.services;

import com.gerenciador.pessoa.dtos.AddressDTO;
import com.gerenciador.pessoa.dtos.AddressRequestDTO;
import com.gerenciador.pessoa.dtos.AddressResponseDTO;
import com.gerenciador.pessoa.entities.Address;
import com.gerenciador.pessoa.entities.People;
import com.gerenciador.pessoa.exceptions.ResourceNotFoundException;
import com.gerenciador.pessoa.mappers.AddressMapper;
import com.gerenciador.pessoa.repository.AddressRepository;
import com.gerenciador.pessoa.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class AddressServico {
    @Autowired
    private AddressRepository repository;

    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private AddressMapper mapper;

    public AddressResponseDTO insert(AddressRequestDTO dto, Long peopleId) {

        Optional<People> peopleOp = peopleRepository.findById(peopleId);
        People peopleEntity = peopleOp
                .orElseThrow(() -> new ResourceNotFoundException("Id da pessoa não existe: " + peopleId));
        Address entity = mapper.addressReqDtoToEntity(dto);
        entity.setPeople(peopleEntity);
        entity.setMain(false);
        repository.save(entity);
        return mapper.entityToAddressResDTO(entity);
    }

    public AddressResponseDTO setAddressMain(Long addressId) {

        Optional<Address> op = repository.findById(addressId);
        Address entity = op.orElseThrow(() -> new ResourceNotFoundException("Endereço não existe: " + addressId));
        Set<Address> peopleAddresses = entity.getPeople().getAddresses();
        for (Address address : peopleAddresses) {
            address.setMain(false);
        }
        entity.setMain(true);
        repository.save(entity);
        return mapper.entityToAddressResDTO(entity);
    }

    public AddressDTO update(AddressDTO id, AddressDTO dto) {
        try {
            Address entity = mapper.dtoToEntity(dto);
            repository.save(entity);
            return mapper.entityToDTO(entity.getPeople());
        } catch (EntityNotFoundException err) {
            throw new ResourceNotFoundException("Id não existem: " + id);
        }
    }
}



