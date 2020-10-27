package com.projetofinal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "itens_venda")
public class ItensVenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@NotNull
	private Integer id;

	@Column
	@NotNull
	private Integer quantidade;

	@Column
	@NotNull
	private Double valorUnitario;

	public ItensVenda() {
		super();
	}

	public ItensVenda(Integer id, Integer quantidade, Double valorUnitario) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
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
