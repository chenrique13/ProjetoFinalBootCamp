package com.projetofinal.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

@Entity
@Table(name = "vendas")
public class Venda implements Serializable {
	private static final long serialVersionUID = 1L;

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

	// Para evitar referencia ciclicas
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	// Para evitar referencia ciclicas
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "formapagamento_id")
	private FormaPagamento formaPagamento;

	// Para evitar referencias ciclicas
	@JsonBackReference
	@OneToMany(mappedBy = "venda")
	private List<ItensVenda> itensVenda = new ArrayList<>();

	public Venda() {
		super();
	}

	public Venda(Integer id, Date dataHora, Double valorTotal, Cliente cliente,
			FormaPagamento formaPagamento) {
		super();
		this.id = id;
		this.dataHora = dataHora;
		this.valorTotal = valorTotal;
		this.cliente = cliente;
		this.formaPagamento = formaPagamento;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
