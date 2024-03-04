package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.Objects;

import com.github.dozermapper.core.Mapping;

import jakarta.validation.constraints.NotNull;

public class RegistroFrequenciaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3469730052398569297L;

	@Mapping(value = "curso.id")
	@NotNull(message = "{campo.dia_frequencia.obrigatorio}")
	private Long idDiaAulaCalendario;

	@Mapping(value = "matricula.id")
	@NotNull(message = "{campo.matricula.obrigatorio}")
	private Long idMatricula;

	@Mapping(value = "situacaoFrequencia.id")
	@NotNull(message = "{campo.situacao_frequencia.obrigatorio}")
	private Long idSituacaoFrequencia;

	public RegistroFrequenciaDTO() {

	}

	public Long getIdDiaAulaCalendario() {
		return idDiaAulaCalendario;
	}

	public void setIdDiaAulaCalendario(Long idDiaAulaCalendario) {
		this.idDiaAulaCalendario = idDiaAulaCalendario;
	}

	public Long getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(Long idMatricula) {
		this.idMatricula = idMatricula;
	}

	public Long getIdSituacaoFrequencia() {
		return idSituacaoFrequencia;
	}

	public void setIdSituacaoFrequencia(Long idSituacaoFrequencia) {
		this.idSituacaoFrequencia = idSituacaoFrequencia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idDiaAulaCalendario, idMatricula, idSituacaoFrequencia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistroFrequenciaDTO other = (RegistroFrequenciaDTO) obj;
		return Objects.equals(idDiaAulaCalendario, other.idDiaAulaCalendario)
				&& Objects.equals(idMatricula, other.idMatricula)
				&& Objects.equals(idSituacaoFrequencia, other.idSituacaoFrequencia);
	}

}
