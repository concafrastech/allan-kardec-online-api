package com.allankardeconline.globalkardec.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import com.allankardeconline.globalkardec.model.categoricos.SituacaoMatricula;
import com.allankardeconline.globalkardec.model.categoricos.VinculoMatricula;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(schema = "globalkardec", name = "matricula")
public class Matricula implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 798939850801205590L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private UUID uuid;

	@JoinColumn(name = "pessoa_id")
	@ManyToOne
	private Pessoa pessoa;

	@Column(name = "data_inicio")
	@Temporal(TemporalType.DATE)
	private LocalDate dataInicio;

	@Column(name = "data_encerramento", nullable = true)
	@Temporal(TemporalType.DATE)
	private LocalDate dataEncerramento;

	@JoinColumn(name = "vinculo_matricula_id")
	@ManyToOne
	private VinculoMatricula vinculoMatricula;

	@JoinColumn(name = "situacao_matricula_id")
	@ManyToOne
	private SituacaoMatricula situacaoMatricula;

	@ManyToOne
	private Turma turma;

	@Column(columnDefinition = "text")
	private String observacao;

	public Matricula() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UUID getUuid() {
		if (uuid == null)
			uuid = UUID.randomUUID();
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(LocalDate dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}

	public VinculoMatricula getVinculoMatricula() {
		return vinculoMatricula;
	}

	public void setVinculoMatricula(VinculoMatricula vinculoMatricula) {
		this.vinculoMatricula = vinculoMatricula;
	}

	public SituacaoMatricula getSituacaoMatricula() {
		return situacaoMatricula;
	}

	public void setSituacaoMatricula(SituacaoMatricula situacaoMatricula) {
		this.situacaoMatricula = situacaoMatricula;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	@Override
	public String toString() {
		return "Matricula [id=" + id + ", uuid=" + uuid + ", pessoa=" + pessoa
				+ ", dataInicio=" + dataInicio + ", dataEncerramento="
				+ dataEncerramento + ", vinculoMatricula=" + vinculoMatricula
				+ ", situacaoMatricula=" + situacaoMatricula + ", turma="
				+ turma + ", observacao=" + observacao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataEncerramento, dataInicio, id, observacao,
				pessoa, situacaoMatricula, turma, uuid, vinculoMatricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matricula other = (Matricula) obj;
		return Objects.equals(dataEncerramento, other.dataEncerramento)
				&& Objects.equals(dataInicio, other.dataInicio)
				&& Objects.equals(id, other.id)
				&& Objects.equals(observacao, other.observacao)
				&& Objects.equals(pessoa, other.pessoa)
				&& Objects.equals(situacaoMatricula, other.situacaoMatricula)
				&& Objects.equals(turma, other.turma)
				&& Objects.equals(uuid, other.uuid)
				&& Objects.equals(vinculoMatricula, other.vinculoMatricula);
	}

}
