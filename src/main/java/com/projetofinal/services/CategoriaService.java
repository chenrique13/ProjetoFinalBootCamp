package com.projetofinal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetofinal.domain.Categoria;
import com.projetofinal.repositorios.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repositorio;

	public Categoria buscar(Integer id) {
		Optional<Categoria> objeto = repositorio.findById(id);

		return objeto.orElse(null);
	}

}
