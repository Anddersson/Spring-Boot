package com.andersonvieira.binary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andersonvieira.binary.domain.Estado;

@Repository
public interface  EstadoRepository extends JpaRepository<Estado, Integer>{
}
