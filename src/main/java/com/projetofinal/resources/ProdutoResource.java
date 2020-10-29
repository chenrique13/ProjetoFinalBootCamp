package com.projetofinal.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.projetofinal.domain.Produto;
import com.projetofinal.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService servico;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> findall() {
		List<Produto> lista = servico.buscarTodos();
		return ResponseEntity.ok().body(lista);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Produto objeto = servico.buscar(id);

		return ResponseEntity.ok().body(objeto);
	}

}
