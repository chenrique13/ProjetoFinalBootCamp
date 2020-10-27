package com.projetofinal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetofinal.domain.FormaPagamento;
import com.projetofinal.repositorios.FormaPagamentoRepository;
import com.projetofinal.services.exceptions.ObjectNotFoundException;

@Service
public class FormaPagamentoService {

	@Autowired
	private FormaPagamentoRepository repositorio;

	public FormaPagamento buscar(Integer id) {
		Optional<FormaPagamento> objeto = repositorio.findById(id);

		return objeto.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + "Tipo" + FormaPagamento.class.getName()));
	}

}
