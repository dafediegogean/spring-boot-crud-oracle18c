package com.poc.sboracl18cxe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.poc.sboracl18cxe.model.Marca;
import com.poc.sboracl18cxe.repository.custom.MarcaCustomRepository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long>, 
	MarcaCustomRepository {
	
}
