package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.Objects;

import com.github.dozermapper.core.Mapping;

import jakarta.validation.constraints.NotNull;

public class EnderecoCadastroDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7989398508012005590L;

	private String logradouro;

	private String numero;

	private String bairro;

	private String codigoPostal;

	@NotNull(message = "{campo.pessoa.cidade}")
	@Mapping(value = "cidade.id")
	private Long idCidade;

	public EnderecoCadastroDTO() {

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

	public Long getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Long idCidade) {
		this.idCidade = idCidade;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairro, codigoPostal, idCidade, logradouro, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnderecoCadastroDTO other = (EnderecoCadastroDTO) obj;
		return Objects.equals(bairro, other.bairro)
				&& Objects.equals(codigoPostal, other.codigoPostal)
				&& Objects.equals(idCidade, other.idCidade)
				&& Objects.equals(logradouro, other.logradouro)
				&& Objects.equals(numero, other.numero);
	}

}
