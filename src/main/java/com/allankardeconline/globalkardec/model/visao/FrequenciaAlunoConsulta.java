package com.allankardeconline.globalkardec.model.visao;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Immutable
@Table(schema = "globalkardec", name = "frequencia_aluno_consulta")
public class FrequenciaAlunoConsulta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -496859864426236862L;

	@Id
	private UUID uuid;

	private String aluno;

	@Column(name = "uuid_turma")
	private UUID uuidTurma;

	@Column(name = "uuid_dia_calendario")
	private UUID uuidDiaCalendario;

	@Column(name = "data_aula")
	private LocalDate dataAula;

	@Column(name = "situacao_frequencia_id")
	private Integer situacaoFrequenciaId;

	@Column(name = "situacao_frequencia")
	private String situacaoFrequencia;

	@Column(name = "aula_especial")
	private Boolean aulaEspecial;

	public FrequenciaAlunoConsulta() {

	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
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

	public LocalDate getDataAula() {
		return dataAula;
	}

	public void setDataAula(LocalDate dataAula) {
		this.dataAula = dataAula;
	}

	public Integer getSituacaoFrequenciaId() {
		return situacaoFrequenciaId;
	}

	public void setSituacaoFrequenciaId(Integer situacaoFrequenciaId) {
		this.situacaoFrequenciaId = situacaoFrequenciaId;
	}

	public String getSituacaoFrequencia() {
		return situacaoFrequencia;
	}

	public void setSituacaoFrequencia(String situacaoFrequencia) {
		this.situacaoFrequencia = situacaoFrequencia;
	}

	public Boolean getAulaEspecial() {
		return aulaEspecial;
	}

	public void setAulaEspecial(Boolean aulaEspecial) {
		this.aulaEspecial = aulaEspecial;
	}

	@Override
	public String toString() {
		return "FrequenciaAlunoConsulta [uuid=" + uuid + ", aluno=" + aluno
				+ ", uuidTurma=" + uuidTurma + ", uuidDiaCalendario="
				+ uuidDiaCalendario + ", dataAula=" + dataAula
				+ ", situacaoFrequenciaId=" + situacaoFrequenciaId
				+ ", situacaoFrequencia=" + situacaoFrequencia
				+ ", aulaEspecial=" + aulaEspecial + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(aluno, aulaEspecial, dataAula, situacaoFrequencia,
				situacaoFrequenciaId, uuid, uuidDiaCalendario, uuidTurma);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FrequenciaAlunoConsulta other = (FrequenciaAlunoConsulta) obj;
		return Objects.equals(aluno, other.aluno)
				&& Objects.equals(aulaEspecial, other.aulaEspecial)
				&& Objects.equals(dataAula, other.dataAula)
				&& Objects.equals(situacaoFrequencia, other.situacaoFrequencia)
				&& Objects.equals(situacaoFrequenciaId,
						other.situacaoFrequenciaId)
				&& Objects.equals(uuid, other.uuid)
				&& Objects.equals(uuidDiaCalendario, other.uuidDiaCalendario)
				&& Objects.equals(uuidTurma, other.uuidTurma);
	}

}
