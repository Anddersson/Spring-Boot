package com.andersonvieira.binary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andersonvieira.binary.domain.Produto;

@Repository
public interface  ProdutoRepository2 extends JpaRepository<Produto, Integer>{
}
	