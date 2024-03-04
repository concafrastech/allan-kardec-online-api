package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;

public class LoteMatriculaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1648240644724105097L;

	@NotNull(message = "{campo.turma_encerrada.obrigatorio}")
	private UUID uuidTurmaEncerrada;

	@NotNull(message = "{campo.turma_nova.aprovado.obrigatorio}")
	private UUID uuidNovaTurmaAprovados;

	@NotNull(message = "{campo.turma_nova.reprovado.obrigatorio}")
	private UUID uuidNovaTurmaReprovados;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@NotNull(message = "{campo.data_inicio.obrigatorio}")
	private LocalDate dataInicio;

	public LoteMatriculaDTO() {

	}

	public UUID getUuidTurmaEncerrada() {
		return uuidTurmaEncerrada;
	}

	public void setUuidTurmaEncerrada(UUID uuidTurmaEncerrada) {
		this.uuidTurmaEncerrada = uuidTurmaEncerrada;
	}

	public UUID getUuidNovaTurmaAprovados() {
		return uuidNovaTurmaAprovados;
	}

	public void setUuidNovaTurmaAprovados(UUID uuidNovaTurmaAprovados) {
		this.uuidNovaTurmaAprovados = uuidNovaTurmaAprovados;
	}

	public UUID getUuidNovaTurmaReprovados() {
		return uuidNovaTurmaReprovados;
	}

	public void setUuidNovaTurmaReprovados(UUID uuidNovaTurmaReprovados) {
		this.uuidNovaTurmaReprovados = uuidNovaTurmaReprovados;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataInicio, uuidNovaTurmaAprovados,
				uuidNovaTurmaReprovados, uuidTurmaEncerrada);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoteMatriculaDTO other = (LoteMatriculaDTO) obj;
		return Objects.equals(dataInicio, other.dataInicio)
				&& Objects.equals(uuidNovaTurmaAprovados,
						other.uuidNovaTurmaAprovados)
				&& Objects.equals(uuidNovaTurmaReprovados,
						other.uuidNovaTurmaReprovados)
				&& Objects.equals(uuidTurmaEncerrada, other.uuidTurmaEncerrada);
	}

	@Override
	public String toString() {
		return "LoteMatriculaDTO [uuidTurmaEncerrada=" + uuidTurmaEncerrada
				+ ", uuidNovaTurmaAprovados=" + uuidNovaTurmaAprovados
				+ ", uuidNovaTurmaReprovados=" + uuidNovaTurmaReprovados
				+ ", dataInicio=" + dataInicio + "]";
	}

}
