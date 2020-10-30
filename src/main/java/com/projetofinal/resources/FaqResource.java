package com.projetofinal.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
//	@RequestMapping(method = RequestMethod.POST)
//	public ResponseEntity <Faq> insert (@RequestBody Faq obj){
//		obj = servico.insert(obj);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
//
//		return ResponseEntity.created(uri).body(obj);
//	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}

}
