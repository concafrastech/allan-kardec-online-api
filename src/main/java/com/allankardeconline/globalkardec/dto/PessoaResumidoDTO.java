package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import com.github.dozermapper.core.Mapping;

import jakarta.validation.constraints.NotEmpty;

public class PessoaResumidoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3643060288918166563L;

	private UUID uuid;

	@NotEmpty(message = "{campo.pessoa.nome}")
	private String nome;

	@Mapping(value = "contato.email")
	private String email;

	public PessoaResumidoDTO() {

	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, nome, uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaResumidoDTO other = (PessoaResumidoDTO) obj;
		return Objects.equals(email, other.email)
				&& Objects.equals(nome, other.nome)
				&& Objects.equals(uuid, other.uuid);
	}

}
