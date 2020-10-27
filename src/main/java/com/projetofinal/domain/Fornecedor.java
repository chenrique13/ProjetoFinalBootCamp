package com.projetofinal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@NotNull
	private Integer id;

	@Column(length = 200)
	@NotNull
	private String nome;

	@Column
	private String endereco;

	@Column(length = 20)
	private String telefone;

	@Column(length = 20, unique = true)
	private String cnpj;

	@Column(length = 200)
	private String email;

	public Fornecedor() {
		super();
	}

	public Fornecedor(Integer id, String nome, String endereco, String telefone, String cnpj, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.cnpj = cnpj;
		this.email = email;
	}

	/**
	 * Gets e Sets
	 * 
	 * @author Cícero Junior
	 */

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}