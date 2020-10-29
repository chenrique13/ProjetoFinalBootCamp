package com.projetofinal.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projetofinal.domain.Faq;
import com.projetofinal.services.FaqService;

@RestController
@RequestMapping(value = "/faq")
public class FaqResource {

	@Autowired
	private FaqService servico;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Faq>> findall() {
		List<Faq> lista = servico.buscarTodos();
		return ResponseEntity.ok().body(lista);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Faq objeto = servico.buscar(id);

		return ResponseEntity.ok().body(objeto);
	}

}
