package com.andersonvieira.binary.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andersonvieira.binary.domain.Cidade;
import com.andersonvieira.binary.repositories.CidadeRepository2;


@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository2 repo;

	public List<Cidade> findByEstado(Integer estadoId) {
		return repo.findCidades(estadoId);
	}
}
	
