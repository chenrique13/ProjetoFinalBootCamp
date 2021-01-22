package com.projetofinal.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = -3478556552907523879L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

	@Column(length = 200)
	private String nome;

	@Column
	private String descricao;
	
	@Column
	private String imgUrl;

	@Column(name = "preco_unitario")
	private Double preco;

	@Column(length = 20)
	private Integer unidade;

	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "id_marca")
	private Marca marca;

	@ManyToOne
	@JoinColumn(name = "id_fornecedor")
	private Fornecedor fornecedor;

	@JsonIgnore
	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
	private List<Faq> faq = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
	private List<ItensVenda> itensVenda = new ArrayList<>();

	public Produto() {

	}
	
	public Produto(Integer id, String nome, String descricao, String imgUrl, Double preco, Integer unidade,
			Categoria categoria, Marca marca, Fornecedor fornecedor) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.imgUrl = imgUrl;
		this.preco = preco;
		this.unidade = unidade;
		this.categoria = categoria;
		this.marca = marca;
		this.fornecedor = fornecedor;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getUnidade() {
		return unidade;
	}

	public void setUnidade(Integer unidade) {
		this.unidade = unidade;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Faq> getFaq() {
		return faq;
	}

	public void setFaq(List<Faq> faq) {
		this.faq = faq;
	}

	public List<ItensVenda> getItensVenda() {
		return itensVenda;
	}

	public void setItensVenda(List<ItensVenda> itensVenda) {
		this.itensVenda = itensVenda;
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}