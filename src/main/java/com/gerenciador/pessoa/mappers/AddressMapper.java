package com.gerenciador.pessoa.mappers;

import com.gerenciador.pessoa.dtos.AddressDTO;
import com.gerenciador.pessoa.dtos.AddressRequestDTO;
import com.gerenciador.pessoa.dtos.AddressResponseDTO;
import com.gerenciador.pessoa.entities.Address;
import com.gerenciador.pessoa.entities.People;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface AddressMapper {

    Address dtoToEntity(AddressDTO addressDTO);

    Address addressReqDtoToEntity(AddressRequestDTO addressReq);

    AddressDTO entityToDTO(People address);

    AddressResponseDTO entityToAddressResDTO(Address address);

    List<AddressDTO> entityListToDTOList(List<Address> addressList);
}
