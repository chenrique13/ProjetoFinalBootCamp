package com.projetofinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projetofinal.domain.Produto;
import com.projetofinal.repositorios.ProdutoRepository;
import com.projetofinal.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repositorio;

	/**
	 * Metodo para buscar todos no repositorio
	 * 
	 * @author Carlos Pereira
	 * @return
	 */
	public List<Produto> buscarTodos() {
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
	public Produto buscar(Integer id) {
		Optional<Produto> objeto = repositorio.findById(id);

		return objeto.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + "Tipo" + Produto.class.getName()));
	}

	/**
	 * Metodo para inserir no repositorio se o id for nulo
	 * 
	 * @author Carlos Pereira
	 * @param obj
	 * @return
	 */
	public Produto inserir(Produto obj) {
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
	public Produto atualizar(Produto obj) {
		Produto novoObj = buscar(obj.getId());
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
	private void atualizarData(Produto novoObj, Produto obj) {

		if (obj.getNome() == null) {
			novoObj.setNome(novoObj.getNome());
		} else {
			novoObj.setNome(obj.getNome());
		}
		if (obj.getDescricao() == null) {
			novoObj.setDescricao(novoObj.getDescricao());
		} else {
			novoObj.setDescricao(obj.getDescricao());
		}
		if (obj.getPreco() == null) {
			novoObj.setPreco(novoObj.getPreco());
		} else {
			novoObj.setPreco(obj.getPreco());
		}
		if (obj.getUnidade() == null) {
			novoObj.setUnidade(novoObj.getUnidade());
		} else {
			novoObj.setUnidade(obj.getUnidade());
		}
	}

}
