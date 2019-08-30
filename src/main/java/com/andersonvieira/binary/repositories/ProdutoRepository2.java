package com.andersonvieira.binary.repositories;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.andersonvieira.binary.domain.Categoria;
import com.andersonvieira.binary.domain.Produto;

@Repository
public interface  ProdutoRepository2 extends JpaRepository<Produto, Integer>{
	
	@Transactional(readOnly=true)
	Page<Produto> findDistintcByNomeContainingAndCategoriasIn(String nome, List<Categoria> categorias, Pageable pageRequest);
}
	