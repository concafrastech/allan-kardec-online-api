package com.allankardeconline.globalkardec.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pre_cadastro", schema = "globalkardec")
public class PreCadastro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 798939850801205590L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String telefone;

	private String email;

	private String campanha;

	@Column(name = "data_inclusao")
	private Date dataInclusao;

	public PreCadastro() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCampanha() {
		return campanha;
	}

	public void setCampanha(String campanha) {
		this.campanha = campanha;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	@Override
	public String toString() {
		return "PreCadastro [id=" + id + ", nome=" + nome + ", telefone="
				+ telefone + ", email=" + email + ", campanha=" + campanha
				+ ", dataInclusao=" + dataInclusao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(campanha, dataInclusao, email, id, nome, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PreCadastro other = (PreCadastro) obj;
		return Objects.equals(campanha, other.campanha)
				&& Objects.equals(dataInclusao, other.dataInclusao)
				&& Objects.equals(email, other.email)
				&& Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome)
				&& Objects.equals(telefone, other.telefone);
	}

}
