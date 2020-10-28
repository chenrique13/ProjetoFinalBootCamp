package com.projetofinal.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

@Entity
@Table(name = "itens_venda")
public class ItensVenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column
	@NotNull
	private Integer quantidade;

	@Column
	@NotNull
	private Double valorUnitario;

	// Para evitar referencia ciclicas
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "produto_id")
	private Produto produto;

	// Para evitar referencia ciclicas
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "venda_id")
	private Venda venda;

	public ItensVenda() {
		super();
	}

	public ItensVenda(Integer quantidade, Double valorUnitario, Produto produto, Venda venda) {
		super();
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.produto = produto;
		this.venda = venda;
	}

	/**
	 * Gets e Sets
	 * 
	 * @author Cícero Junior
	 */

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

}
