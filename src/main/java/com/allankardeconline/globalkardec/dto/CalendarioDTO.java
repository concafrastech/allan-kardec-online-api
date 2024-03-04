package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public class CalendarioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6178430595442137362L;

	private UUID uuid;

	@NotNull(message = "{campo.semestre.obrigatorio}")
	private int semestre;

	@NotNull(message = "{campo.ano.obrigatorio}")
	private int ano;

	public CalendarioDTO() {

	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "CalendarioDTO [uuid=" + uuid + ", semestre=" + semestre
				+ ", ano=" + ano + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ano, semestre, uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CalendarioDTO other = (CalendarioDTO) obj;
		return ano == other.ano && semestre == other.semestre
				&& Objects.equals(uuid, other.uuid);
	}

}
