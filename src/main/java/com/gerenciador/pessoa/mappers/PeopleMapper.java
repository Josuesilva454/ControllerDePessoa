package com.gerenciador.pessoa.mappers;

import com.gerenciador.pessoa.dtos.PeopleAddressesDTO;
import com.gerenciador.pessoa.dtos.PeopleDTO;
import com.gerenciador.pessoa.entities.People;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface PeopleMapper {

    People dtoToEntity(PeopleDTO peopleDTO);

    PeopleDTO entityToDTO(People people);

    PeopleAddressesDTO entityToAddressesDTO(People people);

    List<PeopleDTO> entityListToDtoList(List<People> peopleList);
}