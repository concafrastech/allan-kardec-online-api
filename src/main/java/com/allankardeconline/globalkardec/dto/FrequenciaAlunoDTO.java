package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class FrequenciaAlunoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3469730052398569297L;

	private UUID matricula;

	private Long situacaoFrequencia;

	public FrequenciaAlunoDTO() {

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

	@Override
	public String toString() {
		return "FrequenciaAlunoDTO [matricula=" + matricula
				+ ", situacaoFrequencia=" + situacaoFrequencia + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula, situacaoFrequencia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FrequenciaAlunoDTO other = (FrequenciaAlunoDTO) obj;
		return Objects.equals(matricula, other.matricula)
				&& Objects.equals(situacaoFrequencia, other.situacaoFrequencia);
	}

}
