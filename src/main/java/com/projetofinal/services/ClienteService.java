package com.projetofinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetofinal.domain.Cliente;
import com.projetofinal.repositorios.ClienteRepository;
import com.projetofinal.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repositorio;

	public List<Cliente> buscarTodos() {
		return repositorio.findAll();
	}
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> objeto = repositorio.findById(id);

		return objeto.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + "Tipo" + Cliente.class.getName()));
	}

	public Cliente insert (Cliente obj) {
		obj.setId(null);
		return repositorio.save(obj);
	}
}
