package com.projetofinal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "forma_pagamento")
public class FormaPagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	@NotNull
	private Integer id;

	@Column(length = 200)
	@NotNull
	private String forma;

	@Column
	@NotNull
	private String descricao;

	@Column
	@NotNull
	private boolean ativo;

	public FormaPagamento() {
		super();
	}

	public FormaPagamento(Integer id, String forma, String descricao, boolean ativo) {
		super();
		this.id = id;
		this.forma = forma;
		this.descricao = descricao;
		this.ativo = ativo;
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

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}