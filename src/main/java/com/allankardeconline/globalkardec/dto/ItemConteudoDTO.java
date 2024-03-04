package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import com.github.dozermapper.core.Mapping;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ItemConteudoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6539850801205590L;

	private UUID uuid;

	@NotEmpty(message = "{campo.nome.obrigatorio}")
	private String nome;

	@NotEmpty(message = "{campo.descricao.obrigatorio}")
	private String descricao;

	@NotEmpty(message = "{campo.link_recurso.obrigatorio}")
	private String linkRecurso;

	@Mapping(value = "tipoRecursoAula.id")
	@NotNull(message = "{campo.tipo_recurso.obrigatorio}")
	private Long idTipoRecursoAula;

	@Mapping(value = "tipoRecursoAula.nome")
	private String nomeTipoRecursoAula;

	@NotNull(message = "{campo.categoria_materia.obrigatorio}")
	@Mapping(value = "conteudo.uuid")
	private UUID conteudo;

	@Mapping(value = "conteudo.nome")
	private String nomeConteudo;

	@NotNull(message = "{campo.ordem.obrigatorio}")
	private Integer ordem;

	public ItemConteudoDTO() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLinkRecurso() {
		return linkRecurso;
	}

	public void setLinkRecurso(String linkRecurso) {
		this.linkRecurso = linkRecurso;
	}

	public Long getIdTipoRecursoAula() {
		return idTipoRecursoAula;
	}

	public void setIdTipoRecursoAula(Long idTipoRecursoAula) {
		this.idTipoRecursoAula = idTipoRecursoAula;
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

	public String getNomeTipoRecursoAula() {
		return nomeTipoRecursoAula;
	}

	public void setNomeTipoRecursoAula(String nomeTipoRecursoAula) {
		this.nomeTipoRecursoAula = nomeTipoRecursoAula;
	}

	public UUID getConteudo() {
		return conteudo;
	}

	public void setConteudo(UUID conteudo) {
		this.conteudo = conteudo;
	}

	public String getNomeConteudo() {
		return nomeConteudo;
	}

	public void setNomeConteudo(String nomeConteudo) {
		this.nomeConteudo = nomeConteudo;
	}

	@Override
	public String toString() {
		return "ItemConteudoDTO [uuid=" + uuid + ", nome=" + nome
				+ ", descricao=" + descricao + ", linkRecurso=" + linkRecurso
				+ ", idTipoRecursoAula=" + idTipoRecursoAula
				+ ", nomeTipoRecursoAula=" + nomeTipoRecursoAula + ", conteudo="
				+ conteudo + ", nomeConteudo=" + nomeConteudo + ", ordem="
				+ ordem + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(conteudo, descricao, idTipoRecursoAula, linkRecurso,
				nome, nomeConteudo, nomeTipoRecursoAula, ordem, uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemConteudoDTO other = (ItemConteudoDTO) obj;
		return Objects.equals(conteudo, other.conteudo)
				&& Objects.equals(descricao, other.descricao)
				&& Objects.equals(idTipoRecursoAula, other.idTipoRecursoAula)
				&& Objects.equals(linkRecurso, other.linkRecurso)
				&& Objects.equals(nome, other.nome)
				&& Objects.equals(nomeConteudo, other.nomeConteudo)
				&& Objects.equals(nomeTipoRecursoAula,
						other.nomeTipoRecursoAula)
				&& Objects.equals(ordem, other.ordem)
				&& Objects.equals(uuid, other.uuid);
	}

}
