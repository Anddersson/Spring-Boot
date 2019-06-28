package com.andersonvieira.binary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andersonvieira.binary.domain.Endereco;

@Repository
public interface  EnderecoRepository extends JpaRepository<Endereco, Integer>{
}
