package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;

public class IdiomaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1398508205590L;

	private UUID uuid;

	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String nome;

	public IdiomaDTO() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

}
