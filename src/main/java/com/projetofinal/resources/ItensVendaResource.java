package com.projetofinal.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ItensVenda>> findall() {
		List<ItensVenda> lista = servico.buscarTodos();
		return ResponseEntity.ok().body(lista);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		ItensVenda objeto = servico.buscar(id);

		return ResponseEntity.ok().body(objeto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}

}
