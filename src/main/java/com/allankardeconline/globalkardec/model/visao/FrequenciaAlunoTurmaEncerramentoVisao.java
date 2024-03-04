package com.allankardeconline.globalkardec.model.visao;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import org.hibernate.annotations.Immutable;

import com.allankardeconline.globalkardec.model.Turma;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Immutable
@Table(schema = "globalkardec", name = "frequencia_aluno_turma_encerramento")
public class FrequenciaAlunoTurmaEncerramentoVisao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -496859864426236862L;

	@Id
	private UUID matricula;

	private String nome;

	@JoinColumn(name = "turma_id")
	@ManyToOne
	private Turma turma;

	@Column(name = "dias_aula")
	private Integer diasAula;

	@Column(name = "dias_frequencia_registrada")
	private Integer diasFrequenciaRegistrada;

	@Column(name = "dias_presentes")
	private Integer diasPresentes;

	public FrequenciaAlunoTurmaEncerramentoVisao() {

	}

	public UUID getMatricula() {
		return matricula;
	}

	public void setMatricula(UUID matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Integer getDiasAula() {
		return diasAula;
	}

	public void setDiasAula(Integer diasAula) {
		this.diasAula = diasAula;
	}

	public Integer getDiasFrequenciaRegistrada() {
		return diasFrequenciaRegistrada;
	}

	public void setDiasFrequenciaRegistrada(Integer diasFrequenciaRegistrada) {
		this.diasFrequenciaRegistrada = diasFrequenciaRegistrada;
	}

	public Integer getDiasPresentes() {
		return diasPresentes;
	}

	public void setDiasPresentes(Integer diasPresentes) {
		this.diasPresentes = diasPresentes;
	}

	@Override
	public String toString() {
		return "FrequenciaAlunoTurmaEncerramentoVisao [matricula=" + matricula
				+ ", nome=" + nome + ", turma=" + turma + ", diasAula="
				+ diasAula + ", diasFrequenciaRegistrada="
				+ diasFrequenciaRegistrada + ", diasPresentes=" + diasPresentes
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(diasAula, diasFrequenciaRegistrada, diasPresentes,
				matricula, nome, turma);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FrequenciaAlunoTurmaEncerramentoVisao other = (FrequenciaAlunoTurmaEncerramentoVisao) obj;
		return Objects.equals(diasAula, other.diasAula)
				&& Objects.equals(diasFrequenciaRegistrada,
						other.diasFrequenciaRegistrada)
				&& Objects.equals(diasPresentes, other.diasPresentes)
				&& Objects.equals(matricula, other.matricula)
				&& Objects.equals(nome, other.nome)
				&& Objects.equals(turma, other.turma);
	}

}
