package com.projetofinal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetofinal.domain.Fornecedor;
import com.projetofinal.repositorios.FornecedorRepository;
import com.projetofinal.services.exceptions.ObjectNotFoundException;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository repositorio;

	public Fornecedor buscar(Integer id) {
		Optional<Fornecedor> objeto = repositorio.findById(id);

		return objeto.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + "Tipo" + Fornecedor.class.getName()));
	}

}
