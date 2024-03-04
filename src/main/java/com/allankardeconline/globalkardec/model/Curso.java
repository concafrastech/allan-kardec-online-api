package com.allankardeconline.globalkardec.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import com.allankardeconline.globalkardec.model.categoricos.TipoCurso;
import com.allankardeconline.util.enumeradores.ModalidadeEnsinoEnumerador;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(schema = "globalkardec", name = "curso")
public class Curso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 798939850801205590L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private UUID uuid;

	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String nome;

	@Column(name = "capa_curso")
	@NotEmpty(message = "{campo.capa_curso.obrigatorio}")
	private String capaCurso;

	@Column(columnDefinition = "text")
	private String descricao;

	@ManyToOne
	private Instituto instituto;

	@JoinColumn(name = "language_id")
	@ManyToOne
	private Idioma idioma;

	@JoinColumn(name = "tipo_curso_id")
	@ManyToOne
	private TipoCurso tipoCurso;

	@Enumerated
	private ModalidadeEnsinoEnumerador modalidadeEnsino;

	public Curso() {

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCapaCurso() {
		return capaCurso;
	}

	public void setCapaCurso(String capaCurso) {
		this.capaCurso = capaCurso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Instituto getInstituto() {
		return instituto;
	}

	public void setInstituto(Instituto instituto) {
		this.instituto = instituto;
	}

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

	public TipoCurso getTipoCurso() {
		return tipoCurso;
	}

	public void setTipoCurso(TipoCurso tipoCurso) {
		this.tipoCurso = tipoCurso;
	}

	public ModalidadeEnsinoEnumerador getModalidadeEnsino() {
		return modalidadeEnsino;
	}

	public void setModalidadeEnsino(
			ModalidadeEnsinoEnumerador modalidadeEnsino) {
		this.modalidadeEnsino = modalidadeEnsino;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", uuid=" + uuid + ", nome=" + nome
				+ ", capaCurso=" + capaCurso + ", descricao=" + descricao
				+ ", instituto=" + instituto + ", idioma=" + idioma
				+ ", tipoCurso=" + tipoCurso + ", modalidadeEnsino="
				+ modalidadeEnsino + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(capaCurso, descricao, id, idioma, instituto,
				modalidadeEnsino, nome, tipoCurso, uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(capaCurso, other.capaCurso)
				&& Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id)
				&& Objects.equals(idioma, other.idioma)
				&& Objects.equals(instituto, other.instituto)
				&& modalidadeEnsino == other.modalidadeEnsino
				&& Objects.equals(nome, other.nome)
				&& Objects.equals(tipoCurso, other.tipoCurso)
				&& Objects.equals(uuid, other.uuid);
	}

}
