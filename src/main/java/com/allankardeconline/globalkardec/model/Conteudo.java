package com.allankardeconline.globalkardec.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "globalkardec", name = "conteudo")
public class Conteudo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 798939850801205590L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private UUID uuid;

	private String nome;

	private Integer ordem;

	@JoinColumn(name = "curso_id")
	@ManyToOne()
	private Curso curso;

	public Conteudo() {

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

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public UUID getUuid() {

		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Conteudo [id=" + id + ", uuid=" + uuid + ", nome=" + nome
				+ ", ordem=" + ordem + ", curso=" + curso + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(curso, id, nome, ordem, uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conteudo other = (Conteudo) obj;
		return Objects.equals(curso, other.curso)
				&& Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome)
				&& Objects.equals(ordem, other.ordem)
				&& Objects.equals(uuid, other.uuid);
	}

}
