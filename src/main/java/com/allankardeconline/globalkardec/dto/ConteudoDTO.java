package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import com.github.dozermapper.core.Mapping;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ConteudoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 139850801205590L;

	private UUID uuid;

	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String nome;

	@NotNull(message = "{campo.ordem.obrigatorio}")
	private Integer ordem;

	@Mapping(value = "curso.uuid")
	@NotNull(message = "{campo.curso.obrigatorio}")
	private UUID curso;

	@Mapping(value = "curso.nome")
	private String nomeCurso;

	public ConteudoDTO() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public UUID getCurso() {
		return curso;
	}

	public void setCurso(UUID curso) {
		this.curso = curso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	@Override
	public String toString() {
		return "ConteudoDTO [uuid=" + uuid + ", nome=" + nome + ", ordem="
				+ ordem + ", curso=" + curso + ", nomeCurso=" + nomeCurso + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(curso, nome, nomeCurso, ordem, uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConteudoDTO other = (ConteudoDTO) obj;
		return Objects.equals(curso, other.curso)
				&& Objects.equals(nome, other.nome)
				&& Objects.equals(nomeCurso, other.nomeCurso)
				&& Objects.equals(ordem, other.ordem)
				&& Objects.equals(uuid, other.uuid);
	}

}
