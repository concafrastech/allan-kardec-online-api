package com.allankardeconline.globalkardec.model.categoricos;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(schema = "auxiliar", name = "situacao_matricula")
public class SituacaoMatricula implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 798939850801205590L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "{campo.nome.obrigatorio}")
	private String nome;

	public static SituacaoMatricula MATRICULADO = new SituacaoMatricula(1l);
	public static SituacaoMatricula APROVADO = new SituacaoMatricula(2l);
	public static SituacaoMatricula REPROVADO = new SituacaoMatricula(3l);

	public SituacaoMatricula() {

	}

	public SituacaoMatricula(Long id) {
		this.id = id;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SituacaoMatricula other = (SituacaoMatricula) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

}
