package com.projetofinal.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "itens_venda")
public class ItensVenda {

	@Column
	@NotNull
	private Venda venda;

	@Column
	@NotNull
	private Produto produto;

	@Column
	@NotNull
	private Integer quantidade;

	@Column
	@NotNull
	private Double valorUnitario;

	public ItensVenda() {
		super();
	}

	public ItensVenda(Integer quantidade, Double valorUnitario) {
		super();
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
	}

	/**
	 * Gets e Sets
	 * 
	 * @author Cícero Junior
	 */

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
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
