package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.Objects;

public class EnderecoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7989398508012005590L;

	private String logradouro;

	private String numero;

	private String bairro;

	private String codigoPostal;

	private CidadeDTO cidade;

	public EnderecoDTO() {

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

	public CidadeDTO getCidade() {
		return cidade;
	}

	public void setCidade(CidadeDTO cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "EnderecoDTO [logradouro=" + logradouro + ", numero=" + numero
				+ ", bairro=" + bairro + ", codigoPostal=" + codigoPostal
				+ ", cidade=" + cidade + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cidade, codigoPostal, logradouro, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnderecoDTO other = (EnderecoDTO) obj;
		return Objects.equals(bairro, other.bairro)
				&& Objects.equals(cidade, other.cidade)
				&& Objects.equals(codigoPostal, other.codigoPostal)
				&& Objects.equals(logradouro, other.logradouro)
				&& Objects.equals(numero, other.numero);
	}

}
