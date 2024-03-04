package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.Objects;

import jakarta.validation.constraints.NotEmpty;

public class TipoDiaCalendarioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 539850801205590L;

	private Long id;

	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String nome;

	public TipoDiaCalendarioDTO() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoDiaCalendarioDTO other = (TipoDiaCalendarioDTO) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

}
