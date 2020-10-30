package com.projetofinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projetofinal.domain.Marca;
import com.projetofinal.repositorios.MarcaRepository;
import com.projetofinal.services.exceptions.ObjectNotFoundException;

@Service
public class MarcaService {

	@Autowired
	private MarcaRepository repositorio;
	
	public List<Marca> buscarTodos() {
		return repositorio.findAll();
	}

	public Marca buscar(Integer id) {
		Optional<Marca> objeto = repositorio.findById(id);

		return objeto.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + "Tipo" + Marca.class.getName()));
	}
	
	public void delete(Integer id) {
		try {
			repositorio.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException("Cliente não encontrada na base de dados para ser deletado.");
		}
	}

}
