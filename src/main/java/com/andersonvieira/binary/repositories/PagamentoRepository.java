package com.andersonvieira.binary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andersonvieira.binary.domain.Pagamento;

@Repository
public interface  PagamentoRepository extends JpaRepository<Pagamento, Integer>{
}
