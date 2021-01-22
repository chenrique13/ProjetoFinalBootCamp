package com.projetofinal.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.projetofinal.domain.Cliente;
import com.projetofinal.repositorios.ClienteRepository;
import com.projetofinal.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repositorio;

	/**
	 * Metodo para buscar todos no repositorio
	 * 
	 * @author Carlos Pereira
	 * @return
	 */
	public List<Cliente> buscarTodos() {
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
	public Cliente buscar(Integer id) {
		Optional<Cliente> objeto = repositorio.findById(id);

		return objeto.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! ID: " + id + "Tipo" + Cliente.class.getName()));
	}

	/**
	 * Metodo para inserir no repositorio se o id for nulo
	 * 
	 * @author Carlos Pereira
	 * @param obj
	 * @return
	 */
	public Cliente inserir(Cliente obj) {
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
	public Cliente atualizar(Cliente obj) {
		Cliente novoObj = buscar(obj.getId());
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
	private void atualizarData(Cliente novoObj, Cliente obj) {

		if (obj.getNome() == null) {
			novoObj.setNome(novoObj.getNome());
		} else {
			novoObj.setNome(obj.getNome());
		}

		if (obj.getCpf() == null) {
			novoObj.setCpf(novoObj.getCpf());
		} else {
			novoObj.setCpf(obj.getCpf());
		}

		if (obj.getEmail() == null) {
			novoObj.setEmail(novoObj.getEmail());
		} else {
			novoObj.setEmail(obj.getEmail());
		}
		if (obj.getDataNascimento() == null) {
			novoObj.setDataNascimento(novoObj.getDataNascimento());
		} else {
			novoObj.setDataNascimento(obj.getDataNascimento());
		}
		if (obj.getSexo() == null) {
			novoObj.setSexo(novoObj.getSexo());
		} else {
			novoObj.setSexo(obj.getSexo());
		}
		if (obj.getNomeSocial() == null) {
			novoObj.setNomeSocial(novoObj.getNomeSocial());
		} else {
			novoObj.setNomeSocial(obj.getNomeSocial());
		}
		if (obj.getApelido() == null) {
			novoObj.setApelido(novoObj.getApelido());
		} else {
			novoObj.setApelido(obj.getApelido());
		}
		if (obj.getTelefone() == null) {
			novoObj.setTelefone(novoObj.getTelefone());
		} else {
			novoObj.setTelefone(obj.getTelefone());
		}
	}
}
