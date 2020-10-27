package com.projetofinal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetofinal.domain.Produto;
import com.projetofinal.repositorios.ProdutoRepository;
import com.projetofinal.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repositorio;

	public Produto buscar(Integer id) {
		Optional<Produto> objeto = repositorio.findById(id);

		return objeto.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + "Tipo" + Produto.class.getName()));
	}

}
