package com.projetofinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projetofinal.domain.ItensVenda;
import com.projetofinal.repositorios.ItensVendaRepository;
import com.projetofinal.services.exceptions.ObjectNotFoundException;

@Service
public class ItensVendaService {

	@Autowired
	private ItensVendaRepository repositorio;

	/**
	 * Metodo para buscar todos no repositorio
	 * 
	 * @author Carlos Pereira
	 * @return
	 */
	public List<ItensVenda> buscarTodos() {
		return repositorio.findAll();
	}

	/**
	 * Metodo para buscar por id no repositorio e se nao tiver retornar mensagem de
	 * erro
	 * 
	 * @author Carlos Pereira
	 * @param id
	 * @return
	 */
	public ItensVenda buscar(Integer id) {
		Optional<ItensVenda> objeto = repositorio.findById(id);

		return objeto.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + "Tipo" + ItensVenda.class.getName()));
	}

	/**
	 * Metodo para inserir no repositorio se o id for nulo
	 * 
	 * @author Carlos Pereira
	 * @param obj
	 * @return
	 */
	public ItensVenda inserir(ItensVenda obj) {
		obj.setId(null);
		return repositorio.save(obj);
	}

	/**
	 * Metodo para deletar do repositorio por id e se nao tiver retornar mensagem de
	 * erro
	 * 
	 * @author Cícero Junior
	 * @param id
	 */
	public void delete(Integer id) {
		try {
			repositorio.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException("Cliente não encontrada na base de dados para ser deletado.");
		}
	}

}
