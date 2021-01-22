package com.projetofinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projetofinal.domain.Fornecedor;
import com.projetofinal.repositorios.FornecedorRepository;
import com.projetofinal.services.exceptions.ObjectNotFoundException;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository repositorio;

	/**
	 * Metodo para buscar todos no repositorio
	 * 
	 * @author Carlos Pereira
	 * @return
	 */
	public List<Fornecedor> buscarTodos() {
		return repositorio.findAllByOrderByIdAsc();
	}

	/**
	 * Metodo para buscar por id no repositorio e se nao tiver retornar mensagem de
	 * erro
	 * 
	 * @author Carlos Pereira
	 * @param id
	 * @return
	 */
	public Fornecedor buscar(Integer id) {
		Optional<Fornecedor> objeto = repositorio.findById(id);

		return objeto.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + "Tipo" + Fornecedor.class.getName()));
	}

	/**
	 * Metodo para inserir no repositorio se o id for nulo
	 * 
	 * @author Carlos Pereira
	 * @param obj
	 * @return
	 */
	public Fornecedor inserir(Fornecedor obj) {
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
	public Fornecedor atualizar(Fornecedor obj) {
		Fornecedor novoObj = buscar(obj.getId());
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
	private void atualizarData(Fornecedor novoObj, Fornecedor obj) {

		if (obj.getNome() == null) {
			novoObj.setNome(novoObj.getNome());
		} else {
			novoObj.setNome(obj.getNome());
		}
		if (obj.getEndereco() == null) {
			novoObj.setEndereco(novoObj.getEndereco());
		} else {
			novoObj.setEndereco(obj.getEndereco());
		}
		if (obj.getTelefone() == null) {
			novoObj.setTelefone(novoObj.getTelefone());
		} else {
			novoObj.setTelefone(obj.getTelefone());
		}
		if (obj.getCnpj() == null) {
			novoObj.setCnpj(novoObj.getCnpj());
		} else {
			novoObj.setCnpj(obj.getCnpj());
		}
		if (obj.getEmail() == null) {
			novoObj.setEmail(novoObj.getEmail());
		} else {
			novoObj.setEmail(obj.getEmail());
		}

	}
}
