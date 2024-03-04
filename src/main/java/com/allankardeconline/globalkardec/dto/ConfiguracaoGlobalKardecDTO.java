package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import com.github.dozermapper.core.Mapping;

import jakarta.validation.constraints.NotNull;

public class ConfiguracaoGlobalKardecDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 650659524697804953L;

	private Long id;

	@NotNull(message = "{campo.turma.obrigatorio}")
	@Mapping("turmaMatriculaInicial.uuid")
	private UUID turmaMatriculaInicial;

	public ConfiguracaoGlobalKardecDTO() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UUID getTurmaMatriculaInicial() {
		return turmaMatriculaInicial;
	}

	public void setTurmaMatriculaInicial(UUID turmaMatriculaInicial) {
		this.turmaMatriculaInicial = turmaMatriculaInicial;
	}

	@Override
	public String toString() {
		return "ConfiguracaoGlobalKardecDTO [id=" + id
				+ ", turmaMatriculaInicial=" + turmaMatriculaInicial + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, turmaMatriculaInicial);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConfiguracaoGlobalKardecDTO other = (ConfiguracaoGlobalKardecDTO) obj;
		return Objects.equals(id, other.id) && Objects
				.equals(turmaMatriculaInicial, other.turmaMatriculaInicial);
	}

	
}
