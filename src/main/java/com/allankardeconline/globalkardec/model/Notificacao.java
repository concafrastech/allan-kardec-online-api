package com.allankardeconline.globalkardec.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import com.allankardeconline.site.model.CentroEspirita;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(schema = "geral", name = "notificacao")
public class Notificacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 798939850801205590L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private UUID uuid;

	@NotNull(message = "{campo.assunto.obrigatorio}")
	private String assunto;

	@NotNull(message = "{campo.descricao.obrigatorio}")
	private String descricao;

	@JoinColumn(name = "centroespirita_id")
	@ManyToOne
	private CentroEspirita centroEspirita;

	@JoinColumn(name = "curso_id")
	@ManyToOne
	private Curso curso;

	@JoinColumn(name = "turma_id")
	@ManyToOne
	private Turma turma;

	@ManyToOne
	private Metadados criacao;

	public Notificacao() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Metadados getCriacao() {
		return criacao;
	}

	public void setCriacao(Metadados criacao) {
		this.criacao = criacao;
	}

	public CentroEspirita getCentroEspirita() {
		return centroEspirita;
	}

	public void setCentroEspirita(CentroEspirita centroEspirita) {
		this.centroEspirita = centroEspirita;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	@Override
	public String toString() {
		return "Notificacao [id=" + id + ", uuid=" + uuid + ", assunto="
				+ assunto + ", descricao=" + descricao + ", centroEspirita="
				+ centroEspirita + ", curso=" + curso + ", turma=" + turma
				+ ", criacao=" + criacao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(assunto, centroEspirita, criacao, curso, descricao,
				id, turma, uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notificacao other = (Notificacao) obj;
		return Objects.equals(assunto, other.assunto)
				&& Objects.equals(centroEspirita, other.centroEspirita)
				&& Objects.equals(criacao, other.criacao)
				&& Objects.equals(curso, other.curso)
				&& Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id)
				&& Objects.equals(turma, other.turma)
				&& Objects.equals(uuid, other.uuid);
	}

}
