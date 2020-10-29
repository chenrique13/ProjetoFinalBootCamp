package com.projetofinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetofinal.domain.Categoria;
import com.projetofinal.repositorios.CategoriaRepository;
import com.projetofinal.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repositorio;

	public List<Categoria> buscarTodos() {
		return repositorio.findAll();
	}

	public Categoria buscar(Integer id) {
		Optional<Categoria> objeto = repositorio.findById(id);

		return objeto.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + "Tipo" + Categoria.class.getName()));
	}

}
