package com.projetofinal.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projetofinal.domain.ItensVenda;
import com.projetofinal.services.ItensVendaService;

@RestController
@RequestMapping(value = "/itensvendas")
public class ItensVendaResource {

	@Autowired
	private ItensVendaService servico;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		ItensVenda objeto = servico.buscar(id);

		return ResponseEntity.ok().body(objeto);
	}

}
