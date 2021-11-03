package com.poc.sboracl18cxe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;

@Entity
@Table(name = "marca")
@NamedStoredProcedureQueries
		({ 	
			@NamedStoredProcedureQuery(name = "sp_consulta_marca_por_id", procedureName = "sp_consulta_marca_por_id", resultClasses = Marca.class), 
			@NamedStoredProcedureQuery(name = "sp_lista_marcas", procedureName = "sp_lista_marcas", resultClasses = Marca.class)
		})
public class Marca {
	
	@Id
	private Long marcaId;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "data_fundacao")
	private String dataFundacao;

	public Long getMarcaId() {
		return marcaId;
	}

	public void setMarcaId(Long marcaId) {
		this.marcaId = marcaId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(String dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	
}
