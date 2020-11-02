package com.projetofinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projetofinal.domain.FormaPagamento;
import com.projetofinal.repositorios.FormaPagamentoRepository;
import com.projetofinal.services.exceptions.ObjectNotFoundException;

@Service
public class FormaPagamentoService {

	@Autowired
	private FormaPagamentoRepository repositorio;

	/**
	 * Metodo para buscar todos no repositorio
	 * 
	 * @author Carlos Pereira
	 * @return
	 */
	public List<FormaPagamento> buscarTodos() {
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
	public FormaPagamento buscar(Integer id) {
		Optional<FormaPagamento> objeto = repositorio.findById(id);

		return objeto.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + "Tipo" + FormaPagamento.class.getName()));
	}

	/**
	 * Metodo para inserir no repositorio se o id for nulo
	 * 
	 * @author Carlos Pereira
	 * @param obj
	 * @return
	 */
	public FormaPagamento inserir(FormaPagamento obj) {
		obj.setId(null);
		return repositorio.save(obj);
	}

	/**
	 * Metodo para atualizar no repositorio, conferindo se o id do objeto existe
	 * 
	 * @author Carlos Pereira
	 * @param obj
	 * @return
	 */
	public FormaPagamento atualizar(FormaPagamento obj) {
		FormaPagamento novoObj = buscar(obj.getId());
		atualizarData(novoObj, obj);
		return repositorio.save(novoObj);
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

	/**
	 * Metodo para mater valores anteriores quando os atributos nao forem
	 * preenchidos na atualizacao
	 * 
	 * @author Carlos Pereira
	 * @param novoObj
	 * @param obj
	 */
	private void atualizarData(FormaPagamento novoObj, FormaPagamento obj) {

		if (obj.getForma() == null) {
			novoObj.setForma(novoObj.getForma());
		} else {
			novoObj.setForma(obj.getForma());
		}
		if (obj.getDescricao() == null) {
			novoObj.setDescricao(novoObj.getDescricao());
		} else {
			novoObj.setDescricao(obj.getDescricao());
		}
		if (obj.isAtivo() == true) {
			novoObj.setAtivo(true);
		} else {
			novoObj.setAtivo(false);
		}
	}
}
