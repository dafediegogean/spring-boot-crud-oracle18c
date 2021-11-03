package com.poc.sboracl18cxe.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Repository;

import com.poc.sboracl18cxe.model.Marca;
import com.poc.sboracl18cxe.repository.custom.MarcaCustomRepository;

@Repository
public class MarcaRepositoryImpl implements MarcaCustomRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Marca> findAll() {
		StoredProcedureQuery query = 
				em.createNamedStoredProcedureQuery("sp_lista_marcas");
		query.registerStoredProcedureParameter("OUT_CURSOR", Class.class, ParameterMode.REF_CURSOR);
		
		List<Marca> marcas = query.getResultList();
		
		return marcas;
	}
	
	@Override
	public Marca findMarcaById(Long marcaId) {
		StoredProcedureQuery query = 
				em.createNamedStoredProcedureQuery("sp_consulta_marca_por_id");
		query.registerStoredProcedureParameter("in_marcaId", Long.class, ParameterMode.IN);
		query.registerStoredProcedureParameter("OUT_CURSOR", Class.class, ParameterMode.REF_CURSOR);
		query.setParameter("in_marcaId", marcaId);
		
		Marca marca = (Marca) query.getSingleResult();
		
		return marca;
	}
	
}
