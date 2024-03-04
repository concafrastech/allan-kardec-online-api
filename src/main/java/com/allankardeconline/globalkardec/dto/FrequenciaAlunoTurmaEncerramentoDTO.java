package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import com.github.dozermapper.core.Mapping;

public class FrequenciaAlunoTurmaEncerramentoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2978544003288861071L;

	private UUID matricula;

	private String nome;

	@Mapping(value = "turma.uuid")
	private UUID turma;

	@Mapping(value = "turma.curso.nome")
	private String curso;

	private Integer diasAula;

	private Integer diasFrequenciaRegistrada;

	private Integer diasPresentes;
	
	public FrequenciaAlunoTurmaEncerramentoDTO() {

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

	public UUID getTurma() {
		return turma;
	}

	public void setTurma(UUID turma) {
		this.turma = turma;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
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
		return "FrequenciaAlunoTurmaEncerramentoDTO [matricula=" + matricula
				+ ", nome=" + nome + ", turma=" + turma + ", curso=" + curso
				+ ", diasAula=" + diasAula + ", diasFrequenciaRegistrada="
				+ diasFrequenciaRegistrada + ", diasPresentes=" + diasPresentes
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(curso, diasAula, diasFrequenciaRegistrada,
				diasPresentes, matricula, nome, turma);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FrequenciaAlunoTurmaEncerramentoDTO other = (FrequenciaAlunoTurmaEncerramentoDTO) obj;
		return Objects.equals(curso, other.curso)
				&& Objects.equals(diasAula, other.diasAula)
				&& Objects.equals(diasFrequenciaRegistrada,
						other.diasFrequenciaRegistrada)
				&& Objects.equals(diasPresentes, other.diasPresentes)
				&& Objects.equals(matricula, other.matricula)
				&& Objects.equals(nome, other.nome)
				&& Objects.equals(turma, other.turma);
	}

}
