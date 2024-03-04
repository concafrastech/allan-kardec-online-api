package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;

public class InstitutoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3219349933658698990L;

	private UUID uuid;

	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String nome;

	public InstitutoDTO() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UUID getUuid() {
		if (uuid == null)
			uuid = UUID.randomUUID();
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

}
