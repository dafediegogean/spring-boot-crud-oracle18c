package com.poc.sboracl18cxe.service;

import java.util.List;

import com.poc.sboracl18cxe.model.Marca;

public interface MarcaService {

	List<Marca> listar();
	
	Marca buscarMarcaPorId(Long marcaId);
}
