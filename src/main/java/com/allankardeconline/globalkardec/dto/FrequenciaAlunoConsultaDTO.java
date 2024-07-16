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

	@Mapping("uuid")
	private UUID matricula;

	private UUID uuidTurma;

	private UUID uuidDiaCalendario;

	private String aluno;

	private LocalDate dataAula;

	private Long situacaoFrequenciaId;

	private String situacaoFrequencia;

	private Boolean aulaEspecial;

	public FrequenciaAlunoConsultaDTO() {

	}

	public UUID getMatricula() {
		return matricula;
	}

	public void setMatricula(UUID matricula) {
		this.matricula = matricula;
	}

	public LocalDate getDataAula() {
		return dataAula;
	}

	public void setDataAula(LocalDate dataAula) {
		this.dataAula = dataAula;
	}

	public Boolean getAulaEspecial() {
		return aulaEspecial;
	}

	public void setAulaEspecial(Boolean aulaEspecial) {
		this.aulaEspecial = aulaEspecial;
	}

	public String getAluno() {
		return aluno;
	}

	public void setAluno(String aluno) {
		this.aluno = aluno;
	}

	public UUID getUuidTurma() {
		return uuidTurma;
	}

	public void setUuidTurma(UUID uuidTurma) {
		this.uuidTurma = uuidTurma;
	}

	public UUID getUuidDiaCalendario() {
		return uuidDiaCalendario;
	}

	public void setUuidDiaCalendario(UUID uuidDiaCalendario) {
		this.uuidDiaCalendario = uuidDiaCalendario;
	}

	public Long getSituacaoFrequenciaId() {
		return situacaoFrequenciaId;
	}

	public void setSituacaoFrequenciaId(Long situacaoFrequenciaId) {
		this.situacaoFrequenciaId = situacaoFrequenciaId;
	}

	public String getSituacaoFrequencia() {
		return situacaoFrequencia;
	}

	public void setSituacaoFrequencia(String situacaoFrequencia) {
		this.situacaoFrequencia = situacaoFrequencia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aluno, aulaEspecial, dataAula, matricula,
				situacaoFrequencia, situacaoFrequenciaId, uuidDiaCalendario,
				uuidTurma);
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
		return Objects.equals(aluno, other.aluno)
				&& Objects.equals(aulaEspecial, other.aulaEspecial)
				&& Objects.equals(dataAula, other.dataAula)
				&& Objects.equals(matricula, other.matricula)
				&& Objects.equals(situacaoFrequencia, other.situacaoFrequencia)
				&& Objects.equals(situacaoFrequenciaId,
						other.situacaoFrequenciaId)
				&& Objects.equals(uuidDiaCalendario, other.uuidDiaCalendario)
				&& Objects.equals(uuidTurma, other.uuidTurma);
	}

	@Override
	public String toString() {
		return "FrequenciaAlunoConsultaDTO [matricula=" + matricula
				+ ", uuidTurma=" + uuidTurma + ", uuidDiaCalendario="
				+ uuidDiaCalendario + ", aluno=" + aluno + ", dataAula="
				+ dataAula + ", situacaoFrequenciaId=" + situacaoFrequenciaId
				+ ", situacaoFrequencia=" + situacaoFrequencia
				+ ", aulaEspecial=" + aulaEspecial + "]";
	}

}
