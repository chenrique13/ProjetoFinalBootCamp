package com.projetofinal.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projetofinal.domain.ItensVenda;
import com.projetofinal.services.ItensVendaService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/itensvendas")
public class ItensVendaResource {

	@Autowired
	private ItensVendaService servico;

	/**
	 * Metodo buscar todos
	 * 
	 * @author Carlos Pereira
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ItensVenda>> buscarTodos() {
		List<ItensVenda> lista = servico.buscarTodos();
		return ResponseEntity.ok().body(lista);
	}

	/**
	 * Metodo buscar por id
	 * 
	 * @author Carlos Pereira
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ItensVenda> buscar(@PathVariable Integer id) {

		ItensVenda objeto = servico.buscar(id);

		return ResponseEntity.ok().body(objeto);
	}

	/**
	 * Metodo criar
	 * 
	 * @author Carlos Pereira
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ItensVenda> inserir(@RequestBody ItensVenda obj) {
		obj = servico.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.created(uri).body(obj);
	}

	/**
	 * Metodo atualizar por id
	 * 
	 * @author Carlos Pereira
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ItensVenda> atualizar(@RequestBody ItensVenda obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = servico.atualizar(obj);

		return ResponseEntity.ok().body(obj);
	}

	/**
	 * Metodo deletar por id
	 * 
	 * @author Cícero Junior
	 * @return
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Integer id) {
		servico.delete(id);
		return ResponseEntity.noContent().build();
	}

}
