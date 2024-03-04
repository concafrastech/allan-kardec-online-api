package com.allankardeconline.globalkardec.model;

import java.io.Serializable;
import java.util.Objects;

import com.allankardeconline.globalkardec.model.categoricos.SituacaoFrequencia;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "globalkardec", name = "frequencia_aluno")
public class FrequenciaAluno implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 798939850801205590L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JoinColumn(name = "dia_aula_calendario_id")
	@ManyToOne
	private DiaAulaCalendario diaAulaCalendario;

	@ManyToOne
	private Matricula matricula;

	@JoinColumn(name = "situacao_frequencia_id")
	@ManyToOne
	private SituacaoFrequencia situacaoFrequencia;

	@JoinColumn(name = "criacao_id")
	@ManyToOne(cascade = CascadeType.ALL)
	private Metadados criacao;

	public FrequenciaAluno() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DiaAulaCalendario getDiaAulaCalendario() {
		return diaAulaCalendario;
	}

	public void setDiaAulaCalendario(DiaAulaCalendario diaAulaCalendario) {
		this.diaAulaCalendario = diaAulaCalendario;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public SituacaoFrequencia getSituacaoFrequencia() {
		return situacaoFrequencia;
	}

	public void setSituacaoFrequencia(SituacaoFrequencia situacaoFrequencia) {
		this.situacaoFrequencia = situacaoFrequencia;
	}

	public Metadados getCriacao() {
		return criacao;
	}

	public void setCriacao(Metadados criacao) {
		this.criacao = criacao;
	}

	@Override
	public String toString() {
		return "FrequenciaAluno [id=" + id + ", diaAulaCalendario="
				+ diaAulaCalendario + ", matricula=" + matricula
				+ ", situacaoFrequencia=" + situacaoFrequencia + ", criacao="
				+ criacao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(criacao, diaAulaCalendario, id, matricula,
				situacaoFrequencia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FrequenciaAluno other = (FrequenciaAluno) obj;
		return Objects.equals(criacao, other.criacao)
				&& Objects.equals(diaAulaCalendario, other.diaAulaCalendario)
				&& Objects.equals(id, other.id)
				&& Objects.equals(matricula, other.matricula)
				&& Objects.equals(situacaoFrequencia, other.situacaoFrequencia);
	}

}
