package com.projetofinal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetofinal.domain.Cliente;
import com.projetofinal.repositorios.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repositorio;

	public Cliente buscar(Integer id) {
		Optional<Cliente> objeto = repositorio.findById(id);

		return objeto.orElse(null);
	}

}
