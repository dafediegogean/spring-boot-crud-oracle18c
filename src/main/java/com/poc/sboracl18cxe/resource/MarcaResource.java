package com.poc.sboracl18cxe.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.sboracl18cxe.model.Marca;
import com.poc.sboracl18cxe.service.MarcaService;

@RestController
@RequestMapping("/v1")
public class MarcaResource {
	
	@Autowired
	private MarcaService marcaService;
	
	@GetMapping("/marcas")
	public List<Marca> getMarcas() {
		return marcaService.listar();
	}
	
	@GetMapping("/{marcaId}/marcas")
	public ResponseEntity<Marca> getMarcaPorId(@PathVariable("marcaId") Long marcaId) {
		return ResponseEntity.ok(marcaService.buscarMarcaPorId(marcaId));
	}
	
}
