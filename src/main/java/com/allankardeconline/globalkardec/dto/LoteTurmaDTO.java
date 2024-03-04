package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.allankardeconline.util.validacao.ListaNaoVazia;

import jakarta.validation.constraints.NotNull;

public class LoteTurmaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1648240644724105097L;

	@NotNull(message = "{campo.calendario.obrigatorio}")
	private UUID uuidCalendario;

	@ListaNaoVazia(message = "{campo.turma_lote.obrigatorio}")
	private List<UUID> turmas;

	public LoteTurmaDTO() {

	}

	public UUID getUuidCalendario() {
		return uuidCalendario;
	}

	public void setUuidCalendario(UUID uuidCalendario) {
		this.uuidCalendario = uuidCalendario;
	}

	public List<UUID> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<UUID> turmas) {
		this.turmas = turmas;
	}

	@Override
	public String toString() {
		return "LoteTurmaDTO [uuidCalendario=" + uuidCalendario + ", turmas="
				+ turmas + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(turmas, uuidCalendario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoteTurmaDTO other = (LoteTurmaDTO) obj;
		return Objects.equals(turmas, other.turmas)
				&& Objects.equals(uuidCalendario, other.uuidCalendario);
	}

}
