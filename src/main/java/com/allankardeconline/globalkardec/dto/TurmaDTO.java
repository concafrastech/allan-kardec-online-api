package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import com.github.dozermapper.core.Mapping;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class TurmaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1648240644724105097L;

	private UUID uuid;

	@NotEmpty(message = "{campo.link_recurso.obrigatorio}")
	private String linkSala;

	@Mapping(value = "curso.uuid")
	@NotNull(message = "{campo.curso.obrigatorio}")
	private UUID curso;

	@Mapping(value = "curso.nome")
	private String nomeCurso;

	@Mapping(value = "calendario.uuid")
	@NotNull(message = "{campo.calendario.obrigatorio}")
	private UUID calendario;

	@Mapping(value = "calendario.ano")
	private Integer anoCalendario;

	@Mapping(value = "calendario.semestre")
	private Integer semestreCalendario;

	@Mapping(value = "calendario.centroEspirita.uuid")
	private UUID uuidCentro;

	@Mapping(value = "calendario.centroEspirita.nome")
	private String nomeCentro;

	public TurmaDTO() {

	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getLinkSala() {
		return linkSala;
	}

	public void setLinkSala(String linkSala) {
		this.linkSala = linkSala;
	}

	public UUID getCurso() {
		return curso;
	}

	public void setCurso(UUID curso) {
		this.curso = curso;
	}

	public UUID getCalendario() {
		return calendario;
	}

	public void setCalendario(UUID calendario) {
		this.calendario = calendario;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public Integer getAnoCalendario() {
		return anoCalendario;
	}

	public void setAnoCalendario(Integer anoCalendario) {
		this.anoCalendario = anoCalendario;
	}

	public Integer getSemestreCalendario() {
		return semestreCalendario;
	}

	public void setSemestreCalendario(Integer semestreCalendario) {
		this.semestreCalendario = semestreCalendario;
	}

	public UUID getUuidCentro() {
		return uuidCentro;
	}

	public void setUuidCentro(UUID uuidCentro) {
		this.uuidCentro = uuidCentro;
	}

	public String getNomeCentro() {
		return nomeCentro;
	}

	public void setNomeCentro(String nomeCentro) {
		this.nomeCentro = nomeCentro;
	}

	@Override
	public String toString() {
		return "TurmaDTO [uuid=" + uuid + ", linkSala=" + linkSala + ", curso="
				+ curso + ", nomeCurso=" + nomeCurso + ", calendario="
				+ calendario + ", anoCalendario=" + anoCalendario
				+ ", semestreCalendario=" + semestreCalendario + ", uuidCentro="
				+ uuidCentro + ", nomeCentro=" + nomeCentro + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(anoCalendario, calendario, curso, linkSala,
				nomeCentro, nomeCurso, semestreCalendario, uuid, uuidCentro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TurmaDTO other = (TurmaDTO) obj;
		return Objects.equals(anoCalendario, other.anoCalendario)
				&& Objects.equals(calendario, other.calendario)
				&& Objects.equals(curso, other.curso)
				&& Objects.equals(linkSala, other.linkSala)
				&& Objects.equals(nomeCentro, other.nomeCentro)
				&& Objects.equals(nomeCurso, other.nomeCurso)
				&& Objects.equals(semestreCalendario, other.semestreCalendario)
				&& Objects.equals(uuid, other.uuid)
				&& Objects.equals(uuidCentro, other.uuidCentro);
	}

}
