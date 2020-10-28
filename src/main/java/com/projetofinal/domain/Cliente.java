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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@NotNull
	private Integer id;

	@Column(length = 100)
	@NotNull
	private String nome;

	@Column(length = 11, unique = true)
	@NotNull
	private String cpf;

	@Column(length = 200)
	@NotNull
	private String email;

	@Column
	private Date dataNascimento;

	@Column(length = 20)
	private String sexo;

	@Column(length = 100)
	private String nomeSocial;

	@Column(length = 100)
	private String apelido;

	@Column(length = 13)
	private String telefone;

	// Para evitar referencias ciclicas
	@JsonBackReference
	@OneToMany(mappedBy = "cliente")
	private List<Venda> vendas = new ArrayList<>();

	public Cliente() {
		super();
	}

	public Cliente(Integer id, String nome, String cpf, String email, Date dataNascimento, String sexo,
			String nomeSocial, String apelido, String telefone) {

		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.nomeSocial = nomeSocial;
		this.apelido = apelido;
		this.telefone = telefone;
	}

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
