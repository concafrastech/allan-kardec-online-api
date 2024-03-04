package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.dozermapper.core.Mapping;

import jakarta.validation.constraints.NotNull;

public class MatriculaCadastroDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4380096125023939897L;

	private UUID uuid;

	@NotNull(message = "{campo.pessoa.obrigatorio}")
	private UUID pessoa;

	@NotNull(message = "{campo.data_inicio.obrigatorio}")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dataInicio;

	@Mapping(value = "vinculoMatricula.id")
	@NotNull(message = "{campo.vinculo.obrigatorio}")
	private Long vinculoMatricula;

	@Mapping(value = "turma.uuid")
	@NotNull(message = "{campo.turma.obrigatorio}")
	private UUID turma;

	private String observacao;

	public MatriculaCadastroDTO() {

	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public UUID getPessoa() {
		return pessoa;
	}

	public void setPessoa(UUID pessoa) {
		this.pessoa = pessoa;
	}

	public Long getVinculoMatricula() {
		return vinculoMatricula;
	}

	public void setVinculoMatricula(Long vinculoMatricula) {
		this.vinculoMatricula = vinculoMatricula;
	}

	public UUID getTurma() {
		return turma;
	}

	public void setTurma(UUID turma) {
		this.turma = turma;
	}

	@Override
	public String toString() {
		return "MatriculaCadastroDTO [uuid=" + uuid + ", pessoa=" + pessoa
				+ ", dataInicio=" + dataInicio + ", vinculoMatricula="
				+ vinculoMatricula + ", turma=" + turma + ", observacao="
				+ observacao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataInicio, observacao, pessoa, turma, uuid,
				vinculoMatricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatriculaCadastroDTO other = (MatriculaCadastroDTO) obj;
		return Objects.equals(dataInicio, other.dataInicio)
				&& Objects.equals(observacao, other.observacao)
				&& Objects.equals(pessoa, other.pessoa)
				&& Objects.equals(turma, other.turma)
				&& Objects.equals(uuid, other.uuid)
				&& Objects.equals(vinculoMatricula, other.vinculoMatricula);
	}

}
