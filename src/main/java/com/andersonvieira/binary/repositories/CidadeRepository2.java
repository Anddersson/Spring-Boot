package com.andersonvieira.binary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andersonvieira.binary.domain.Cidade;

@Repository
public interface  CidadeRepository2 extends JpaRepository<Cidade, Integer>{
}
