package com.poc.sboracl18cxe.repository.custom;

import java.util.List;

import com.poc.sboracl18cxe.model.Marca;

public interface MarcaCustomRepository {
	
	List<Marca> findAll();
	
	Marca findMarcaById(Long marcaId);
}
