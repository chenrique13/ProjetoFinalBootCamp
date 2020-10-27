package com.projetofinal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetofinal.domain.ItensVenda;
import com.projetofinal.repositorios.ItensVendaRepository;
import com.projetofinal.services.exceptions.ObjectNotFoundException;

@Service
public class ItensVendaService {

	@Autowired
	private ItensVendaRepository repositorio;

	public ItensVenda buscar(Integer id) {
		Optional<ItensVenda> objeto = repositorio.findById(id);

		return objeto.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + "Tipo" + ItensVenda.class.getName()));
	}

}
