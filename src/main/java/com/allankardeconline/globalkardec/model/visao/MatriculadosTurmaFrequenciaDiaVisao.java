package com.allankardeconline.globalkardec.model.visao;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.annotations.Immutable;

import com.allankardeconline.globalkardec.model.DiaAulaCalendario;
import com.allankardeconline.globalkardec.model.Turma;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Immutable
@Table(schema = "globalkardec", name = "matriculados_turma_frequencia_dia")
public class MatriculadosTurmaFrequenciaDiaVisao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -496859864426236862L;

	@Id
	private String id;

	@JoinColumn(name = "turma_id")
	@ManyToOne
	private Turma turma;

	@JoinColumn(name = "dia_aula_calendario_id")
	@ManyToOne 
	private DiaAulaCalendario diaAula;

	private Integer matriculados;

	@Column(name = "frequencias_registradas_dia")
	private Integer frequenciasRegistradas;

	public MatriculadosTurmaFrequenciaDiaVisao() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public DiaAulaCalendario getDiaAula() {
		return diaAula;
	}

	public void setDiaAula(DiaAulaCalendario diaAula) {
		this.diaAula = diaAula;
	}

	public Integer getMatriculados() {
		return matriculados;
	}

	public void setMatriculados(Integer matriculados) {
		this.matriculados = matriculados;
	}

	public Integer getFrequenciasRegistradas() {
		return frequenciasRegistradas;
	}

	public void setFrequenciasRegistradas(Integer frequenciasRegistradas) {
		this.frequenciasRegistradas = frequenciasRegistradas;
	}

	@Override
	public String toString() {
		return "MatriculadosTurmaFrequenciaDia [id=" + id + ", turma=" + turma
				+ ", diaAula=" + diaAula + ", matriculados=" + matriculados
				+ ", frequenciasRegistradas=" + frequenciasRegistradas + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(diaAula, frequenciasRegistradas, id, matriculados,
				turma);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatriculadosTurmaFrequenciaDiaVisao other = (MatriculadosTurmaFrequenciaDiaVisao) obj;
		return Objects.equals(diaAula, other.diaAula)
				&& Objects.equals(frequenciasRegistradas,
						other.frequenciasRegistradas)
				&& Objects.equals(id, other.id)
				&& Objects.equals(matriculados, other.matriculados)
				&& Objects.equals(turma, other.turma);
	}

}
