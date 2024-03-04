package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import com.allankardeconline.util.enumeradores.ModalidadeEnsinoEnumerador;
import com.github.dozermapper.core.Mapping;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class CursoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6208308520103873039L;

	private UUID uuid;

	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String nome;

	@NotEmpty(message = "{campo.capa_curso.obrigatorio}")
	private String capaCurso;

	private String descricao;

	@Mapping(value = "instituto.uuid")
	@NotNull(message = "{campo.instituto.obrigatorio}")
	private UUID instituto;

	@Mapping(value = "idioma.uuid")
	@NotNull(message = "{campo.idioma.obrigatorio}")
	private UUID idioma;

	@Mapping(value = "tipoCurso.id")
	@NotNull(message = "{campo.tipo_curso.obrigatorio}")
	private Long tipoCurso;

	@Mapping(value = "modalidadeEnsino")
	@NotNull(message = "{campo.modalidade.obrigatorio}")
	private ModalidadeEnsinoEnumerador modalidadeEnsino;

	public CursoDTO() {

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

	public UUID getInstituto() {
		return instituto;
	}

	public void setInstituto(UUID instituto) {
		this.instituto = instituto;
	}

	public UUID getIdioma() {
		return idioma;
	}

	public void setIdioma(UUID idioma) {
		this.idioma = idioma;
	}

	public Long getTipoCurso() {
		return tipoCurso;
	}

	public void setTipoCurso(Long tipoCurso) {
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
		return "CursoDTO [uuid=" + uuid + ", nome=" + nome + ", capaCurso="
				+ capaCurso + ", descricao=" + descricao + ", instituto="
				+ instituto + ", idioma=" + idioma + ", tipoCurso=" + tipoCurso
				+ ", modalidadeEnsino=" + modalidadeEnsino + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(capaCurso, descricao, idioma, instituto,
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
		CursoDTO other = (CursoDTO) obj;
		return Objects.equals(capaCurso, other.capaCurso)
				&& Objects.equals(descricao, other.descricao)
				&& Objects.equals(idioma, other.idioma)
				&& Objects.equals(instituto, other.instituto)
				&& modalidadeEnsino == other.modalidadeEnsino
				&& Objects.equals(nome, other.nome)
				&& Objects.equals(tipoCurso, other.tipoCurso)
				&& Objects.equals(uuid, other.uuid);
	}

}
