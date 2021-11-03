package com.poc.sboracl18cxe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.sboracl18cxe.model.Marca;
import com.poc.sboracl18cxe.repository.impl.MarcaRepositoryImpl;
import com.poc.sboracl18cxe.service.MarcaService;

@Service
public class MarcaServiceImpl implements MarcaService {

	@Autowired
	private MarcaRepositoryImpl marcaRepositoryImpl;
		
	@Override
	public List<Marca> listar() {
		return marcaRepositoryImpl.findAll();
	}
	
	@Override
	public Marca buscarMarcaPorId(Long marcaId) {
		return marcaRepositoryImpl.findMarcaById(marcaId);
	}
	
}
