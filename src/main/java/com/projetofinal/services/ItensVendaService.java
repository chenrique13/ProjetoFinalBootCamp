package com.projetofinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projetofinal.domain.ItensVenda;
import com.projetofinal.repositorios.ItensVendaRepository;
import com.projetofinal.services.exceptions.ObjectNotFoundException;

@Service
public class ItensVendaService {

	@Autowired
	private ItensVendaRepository repositorio;
	
	public List<ItensVenda> buscarTodos() {
		return repositorio.findAll();
	}

	public ItensVenda buscar(Integer id) {
		Optional<ItensVenda> objeto = repositorio.findById(id);

		return objeto.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + "Tipo" + ItensVenda.class.getName()));
	}
	
	public void delete(Integer id) {
		try {
			repositorio.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException("Cliente não encontrada na base de dados para ser deletado.");
		}
	}

}
