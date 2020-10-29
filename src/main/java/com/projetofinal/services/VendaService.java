package com.projetofinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetofinal.domain.Venda;
import com.projetofinal.repositorios.VendaRepository;
import com.projetofinal.services.exceptions.ObjectNotFoundException;

@Service
public class VendaService {

	@Autowired
	private VendaRepository repositorio;
	
	public List<Venda> buscarTodos() {
		return repositorio.findAll();
	}

	public Venda buscar(Integer id) {
		Optional<Venda> objeto = repositorio.findById(id);

		return objeto.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + "Tipo" + Venda.class.getName()));
	}

}
