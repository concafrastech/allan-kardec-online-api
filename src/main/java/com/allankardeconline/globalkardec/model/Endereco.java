package com.allankardeconline.globalkardec.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "endereco", schema = "geral")
public class Endereco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7989398508012005590L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String logradouro;

	private String numero;

	private String bairro;

	private String codigoPostal;

	@JoinColumn(name = "cidade_id")
	@ManyToOne
	private Cidade cidade;

	public Endereco() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", logradouro=" + logradouro + ", numero="
				+ numero + ", bairro=" + bairro + ", codigoPostal="
				+ codigoPostal + ", cidade=" + cidade + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cidade, codigoPostal, id, logradouro,
				numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(bairro, other.bairro)
				&& Objects.equals(cidade, other.cidade)
				&& Objects.equals(codigoPostal, other.codigoPostal)
				&& Objects.equals(id, other.id)
				&& Objects.equals(logradouro, other.logradouro)
				&& Objects.equals(numero, other.numero);
	}

}
