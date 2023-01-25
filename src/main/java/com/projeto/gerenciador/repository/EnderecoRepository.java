package com.projeto.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.gerenciador.entities.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
