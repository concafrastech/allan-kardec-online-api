package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import com.github.dozermapper.core.Mapping;

public class FrequenciaAlunoConsultaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3469730052398569297L;

	@Mapping("matricula.uuid")
	private UUID matricula;

	@Mapping("diaAulaCalendario.dataAula")
	private LocalDate dataAula;

	@Mapping("situacaoFrequencia.id")
	private Long situacaoFrequencia;

	@Mapping("situacaoFrequencia.nome")
	private String nomeSituacaoFrequencia;

	@Mapping("diaAulaCalendario.aulaEspecial")
	private Boolean aulaEspecial;

	public FrequenciaAlunoConsultaDTO() {

	}

	public UUID getMatricula() {
		return matricula;
	}

	public void setMatricula(UUID matricula) {
		this.matricula = matricula;
	}

	public Long getSituacaoFrequencia() {
		return situacaoFrequencia;
	}

	public void setSituacaoFrequencia(Long situacaoFrequencia) {
		this.situacaoFrequencia = situacaoFrequencia;
	}

	public LocalDate getDataAula() {
		return dataAula;
	}

	public void setDataAula(LocalDate dataAula) {
		this.dataAula = dataAula;
	}

	public String getNomeSituacaoFrequencia() {
		return nomeSituacaoFrequencia;
	}

	public void setNomeSituacaoFrequencia(String nomeSituacaoFrequencia) {
		this.nomeSituacaoFrequencia = nomeSituacaoFrequencia;
	}

	public Boolean getAulaEspecial() {
		return aulaEspecial;
	}

	public void setAulaEspecial(Boolean aulaEspecial) {
		this.aulaEspecial = aulaEspecial;
	}

	@Override
	public String toString() {
		return "FrequenciaAlunoConsultaDTO [matricula=" + matricula
				+ ", dataAula=" + dataAula + ", situacaoFrequencia="
				+ situacaoFrequencia + ", nomeSituacaoFrequencia="
				+ nomeSituacaoFrequencia + ", aulaEspecial=" + aulaEspecial
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(aulaEspecial, dataAula, matricula,
				nomeSituacaoFrequencia, situacaoFrequencia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FrequenciaAlunoConsultaDTO other = (FrequenciaAlunoConsultaDTO) obj;
		return Objects.equals(aulaEspecial, other.aulaEspecial)
				&& Objects.equals(dataAula, other.dataAula)
				&& Objects.equals(matricula, other.matricula)
				&& Objects.equals(nomeSituacaoFrequencia,
						other.nomeSituacaoFrequencia)
				&& Objects.equals(situacaoFrequencia, other.situacaoFrequencia);
	}

}
