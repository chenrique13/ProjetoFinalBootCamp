package com.projetofinal.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "vendas")
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@NotNull
	private Integer id;

	@Column
	@NotNull
	private Date dataHora;

	@Column(name = "valor_total")
	private Double valorTotal;

	public Venda() {
		super();
	}

	public Venda(Integer id, Date dataHora, FormaPagamento formapagamento, Double valorTotal) {
		super();
		this.id = id;
		this.dataHora = dataHora;
		this.valorTotal = valorTotal;
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

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

}
