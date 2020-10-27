package com.projetofinal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetofinal.domain.Faq;
import com.projetofinal.repositorios.FaqRepository;
import com.projetofinal.services.exceptions.ObjectNotFoundException;

@Service
public class FaqService {

	@Autowired
	private FaqRepository repositorio;

	public Faq buscar(Integer id) {
		Optional<Faq> objeto = repositorio.findById(id);

		return objeto.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + "Tipo" + Faq.class.getName()));
	}

}
