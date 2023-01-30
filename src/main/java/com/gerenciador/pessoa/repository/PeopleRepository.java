package com.gerenciador.pessoa.repository;

import com.gerenciador.pessoa.dtos.PeopleDTO;
import com.gerenciador.pessoa.entities.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {

}