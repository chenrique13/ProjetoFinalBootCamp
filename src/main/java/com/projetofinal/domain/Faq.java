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
@Table
public class Faq {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@NotNull
	private Integer id;

	@Column
	@NotNull
	private Date dataHora;

	@Column
	@NotNull
	private String texto;

	public Faq() {
		super();
	}

	public Faq(Integer id, Date dataHora, String texto) {
		super();
		this.id = id;
		this.dataHora = dataHora;
		this.texto = texto;
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

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}