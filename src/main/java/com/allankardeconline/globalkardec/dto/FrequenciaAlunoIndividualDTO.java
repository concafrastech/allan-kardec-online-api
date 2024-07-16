package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public class FrequenciaAlunoIndividualDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3469730052398569297L;

	@NotNull(message = "{campo.dia_frequencia.obrigatorio}")
	private UUID uuidDiaCalendario;

	@NotNull(message = "{campo.dia_frequencia.obrigatorio}")
	private UUID uuidMatricula;

	public FrequenciaAlunoIndividualDTO() {

	}

	public UUID getUuidDiaCalendario() {
		return uuidDiaCalendario;
	}

	public void setUuidDiaCalendario(UUID uuidDiaCalendario) {
		this.uuidDiaCalendario = uuidDiaCalendario;
	}

	public UUID getUuidMatricula() {
		return uuidMatricula;
	}

	public void setUuidMatricula(UUID uuidMatricula) {
		this.uuidMatricula = uuidMatricula;
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuidDiaCalendario, uuidMatricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FrequenciaAlunoIndividualDTO other = (FrequenciaAlunoIndividualDTO) obj;
		return Objects.equals(uuidDiaCalendario, other.uuidDiaCalendario)
				&& Objects.equals(uuidMatricula, other.uuidMatricula);
	}

	@Override
	public String toString() {
		return "FrequenciaAlunoIndividualDTO [uuidDiaCalendario="
				+ uuidDiaCalendario + ", uuidMatricula=" + uuidMatricula + "]";
	}

}
