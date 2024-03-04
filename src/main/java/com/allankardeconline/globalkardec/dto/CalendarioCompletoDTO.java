package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.allankardeconline.util.validacao.ListaNaoVazia;
import com.github.dozermapper.core.Mapping;

import jakarta.validation.constraints.NotNull;

public class CalendarioCompletoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6178430595442137362L;

	private UUID uuid;

	@NotNull(message = "{campo.centro_espirita.obrigatorio}")
	@Mapping(value = "centroEspirita.uuid")
	private UUID uuidCentro;

	@NotNull(message = "{campo.semestre.obrigatorio}")
	private int semestre;

	@NotNull(message = "{campo.ano.obrigatorio}")
	private int ano;

	@ListaNaoVazia(message = "{campo.dias_aula.obrigatorio}")
	private List<DiaAulaDTO> diasAula;

	public CalendarioCompletoDTO() {

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

	public List<DiaAulaDTO> getDiasAula() {
		return diasAula;
	}

	public void setDiasAula(List<DiaAulaDTO> diasAula) {
		this.diasAula = diasAula;
	}

	@Override
	public String toString() {
		return "CalendarioCompletoDTO [uuid=" + uuid + ", uuidCentro="
				+ uuidCentro + ", semestre=" + semestre + ", ano=" + ano
				+ ", diasAula=" + diasAula + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ano, diasAula, semestre, uuid, uuidCentro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CalendarioCompletoDTO other = (CalendarioCompletoDTO) obj;
		return ano == other.ano && Objects.equals(diasAula, other.diasAula)
				&& semestre == other.semestre
				&& Objects.equals(uuid, other.uuid)
				&& Objects.equals(uuidCentro, other.uuidCentro);
	}

}
