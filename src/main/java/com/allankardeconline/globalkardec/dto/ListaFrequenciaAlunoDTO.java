package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.allankardeconline.util.validacao.ListaNaoVazia;

import jakarta.validation.constraints.NotNull;

public class ListaFrequenciaAlunoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3469730052398569297L;

	@NotNull(message = "{campo.dia_frequencia.obrigatorio}")
	private UUID diaCalendario;

	@ListaNaoVazia(message = "{campo.frequencias.obrigatorio}")
	List<FrequenciaAlunoDTO> frequencias;

	public ListaFrequenciaAlunoDTO() {

	}

	public UUID getDiaCalendario() {
		return diaCalendario;
	}

	public void setDiaCalendario(UUID diaCalendario) {
		this.diaCalendario = diaCalendario;
	}

	public List<FrequenciaAlunoDTO> getFrequencias() {
		return frequencias;
	}

	public void setFrequencias(List<FrequenciaAlunoDTO> frequencias) {
		this.frequencias = frequencias;
	}

	@Override
	public String toString() {
		return "ListaFrequenciaAlunoDTO [diaCalendario=" + diaCalendario
				+ ", frequencias=" + frequencias + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(diaCalendario, frequencias);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaFrequenciaAlunoDTO other = (ListaFrequenciaAlunoDTO) obj;
		return Objects.equals(diaCalendario, other.diaCalendario)
				&& Objects.equals(frequencias, other.frequencias);
	}

}
