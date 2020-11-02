package com.projetofinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projetofinal.domain.Categoria;
import com.projetofinal.repositorios.CategoriaRepository;
import com.projetofinal.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repositorio;

	/**
	 * Metodo para buscar todos no repositorio
	 * 
	 * @author Carlos Pereira
	 * @return
	 */
	public List<Categoria> buscarTodos() {
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
	public Categoria buscar(Integer id) {
		Optional<Categoria> objeto = repositorio.findById(id);

		return objeto.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + "Tipo" + Categoria.class.getName()));
	}

	/**
	 * Metodo para inserir no repositorio se o id for nulo
	 * 
	 * @author Carlos Pereira
	 * @param obj
	 * @return
	 */
	public Categoria inserir(Categoria obj) {
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
	public Categoria atualizar(Categoria obj) {
		Categoria novoObj = buscar(obj.getId());
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
	private void atualizarData(Categoria novoObj, Categoria obj) {

		if (obj.getNome() == null) {
			novoObj.setNome(novoObj.getNome());
		} else {
			novoObj.setNome(obj.getNome());
		}

		if (obj.isAtivo() == true) {
			novoObj.setAtivo(true);
		} else {
			novoObj.setAtivo(false);
		}
	}
}
