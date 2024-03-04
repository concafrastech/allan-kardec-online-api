package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import com.github.dozermapper.core.Mapping;

public class CentroEspiritaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3175650017767314909L;

	private UUID uuid;

	private String nome;

	@Mapping(value = "endereco.cidade.nome")
	private String cidade;

	@Mapping(value = "endereco.cidade.estado.nome")
	private String estado;

	public CentroEspiritaDTO() {

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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "CentroEspiritaDTO [uuid=" + uuid + ", nome=" + nome
				+ ", cidade=" + cidade + ", estado=" + estado + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cidade, estado, nome, uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CentroEspiritaDTO other = (CentroEspiritaDTO) obj;
		return Objects.equals(cidade, other.cidade)
				&& Objects.equals(estado, other.estado)
				&& Objects.equals(nome, other.nome)
				&& Objects.equals(uuid, other.uuid);
	}

}
