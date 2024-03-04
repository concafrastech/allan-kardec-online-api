package com.allankardeconline.globalkardec.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "globalkardec", name = "turma")
public class Turma implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 798939850801205590L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private UUID uuid;

	private String linkSala;

	@ManyToOne
	private Curso curso;

	@ManyToOne(cascade = CascadeType.ALL)
	private Metadados criacao;

	@ManyToOne
	private Calendario calendario;

	@Column(name = "data_encerramento")
	private Date dataEncerramento;

	public Turma() {

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

	public String getLinkSala() {
		return linkSala;
	}

	public void setLinkSala(String linkSala) {
		this.linkSala = linkSala;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Metadados getCriacao() {
		return criacao;
	}

	public void setCriacao(Metadados criacao) {
		this.criacao = criacao;
	}

	public Calendario getCalendario() {
		return calendario;
	}

	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}

	public Date getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(Date dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}

	@Override
	public String toString() {
		return "Turma [id=" + id + ", uuid=" + uuid + ", linkSala=" + linkSala
				+ ", curso=" + curso + ", criacao=" + criacao + ", calendario="
				+ calendario + ", dataEncerramento=" + dataEncerramento + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(calendario, criacao, curso, dataEncerramento, id,
				linkSala, uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		return Objects.equals(calendario, other.calendario)
				&& Objects.equals(criacao, other.criacao)
				&& Objects.equals(curso, other.curso)
				&& Objects.equals(dataEncerramento, other.dataEncerramento)
				&& Objects.equals(id, other.id)
				&& Objects.equals(linkSala, other.linkSala)
				&& Objects.equals(uuid, other.uuid);
	}

}
