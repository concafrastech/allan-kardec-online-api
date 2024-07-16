package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import com.github.dozermapper.core.Mapping;

import jakarta.validation.constraints.NotNull;

public class CalendarioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6178430595442137362L;

	private UUID uuid;
	
	@Mapping(value = "centroEspirita.uuid")
	private UUID uuidCentro;
	
	@Mapping(value = "centroEspirita.nome")
	private String centro;

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

	public UUID getUuidCentro() {
		return uuidCentro;
	}

	public void setUuidCentro(UUID uuidCentro) {
		this.uuidCentro = uuidCentro;
	}

	public String getCentro() {
		return centro;
	}

	public void setCentro(String centro) {
		this.centro = centro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ano, centro, semestre, uuid, uuidCentro);
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
		return ano == other.ano && Objects.equals(centro, other.centro)
				&& semestre == other.semestre
				&& Objects.equals(uuid, other.uuid)
				&& Objects.equals(uuidCentro, other.uuidCentro);
	}

	@Override
	public String toString() {
		return "CalendarioDTO [uuid=" + uuid + ", uuidCentro=" + uuidCentro
				+ ", centro=" + centro + ", semestre=" + semestre + ", ano="
				+ ano + "]";
	}

	

}
