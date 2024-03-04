package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import com.allankardeconline.util.enumeradores.ModalidadeEnsinoEnumerador;
import com.github.dozermapper.core.Mapping;

public class CursoConsultaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6208308520103873039L;

	private UUID uuid;

	private String nome;

	private String capaCurso;

	private String descricao;

	@Mapping(value = "instituto.nome")
	private String nomeInstituto;

	@Mapping(value = "idioma.nome")
	private String nomeIdioma;

	@Mapping(value = "tipoCurso.nome")
	private String nomeTipoCurso;

	@Mapping(value = "modalidadeEnsino")
	private ModalidadeEnsinoEnumerador modalidadeEnsino;

	public CursoConsultaDTO() {

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

	public String getNomeInstituto() {
		return nomeInstituto;
	}

	public void setNomeInstituto(String nomeInstituto) {
		this.nomeInstituto = nomeInstituto;
	}

	public String getNomeIdioma() {
		return nomeIdioma;
	}

	public void setNomeIdioma(String nomeIdioma) {
		this.nomeIdioma = nomeIdioma;
	}

	public String getNomeTipoCurso() {
		return nomeTipoCurso;
	}

	public void setNomeTipoCurso(String nomeTipoCurso) {
		this.nomeTipoCurso = nomeTipoCurso;
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
		return "CursoConsultaDTO [uuid=" + uuid + ", nome=" + nome
				+ ", capaCurso=" + capaCurso + ", descricao=" + descricao
				+ ", nomeInstituto=" + nomeInstituto + ", nomeIdioma="
				+ nomeIdioma + ", nomeTipoCurso=" + nomeTipoCurso
				+ ", modalidadeEnsino=" + modalidadeEnsino + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(capaCurso, descricao, modalidadeEnsino, nome,
				nomeIdioma, nomeInstituto, nomeTipoCurso, uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CursoConsultaDTO other = (CursoConsultaDTO) obj;
		return Objects.equals(capaCurso, other.capaCurso)
				&& Objects.equals(descricao, other.descricao)
				&& modalidadeEnsino == other.modalidadeEnsino
				&& Objects.equals(nome, other.nome)
				&& Objects.equals(nomeIdioma, other.nomeIdioma)
				&& Objects.equals(nomeInstituto, other.nomeInstituto)
				&& Objects.equals(nomeTipoCurso, other.nomeTipoCurso)
				&& Objects.equals(uuid, other.uuid);
	}

}
