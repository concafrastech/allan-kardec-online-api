package com.allankardeconline.globalkardec.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import com.allankardeconline.globalkardec.model.categoricos.TipoRecursoAula;
import com.allankardeconline.site.model.CentroEspirita;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(schema = "globalkardec", name = "item_conteudo")
public class ItemConteudo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 798939850801205590L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private UUID uuid;

	@NotNull(message = "{campo.nome.obrigatorio}")
	private String nome;

	@Column(columnDefinition = "text")
	private String descricao;

	@NotNull(message = "{campo.link_recurso.obrigatorio}")
	@Column(name = "link_recurso")
	private String linkRecurso;

	@JoinColumn(name = "tipo_recurso_aula_id")
	@ManyToOne
	private TipoRecursoAula tipoRecursoAula;

	@JoinColumn(name = "conteudo_id")
	@ManyToOne
	private Conteudo conteudo;

	@JoinColumn(name = "member_spiritist_center_id")
	@ManyToOne
	private CentroEspirita centroEspirita;

	@JoinColumn(name = "criacao_id")
	@ManyToOne(cascade = CascadeType.ALL)
	private Metadados criacao;

	private Integer ordem;

	private boolean visivel;

	private boolean acessoGlobal;

	public ItemConteudo() {

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

	public boolean isVisivel() {
		return visivel;
	}

	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}

	public Metadados getCriacao() {
		return criacao;
	}

	public void setCriacao(Metadados criacao) {
		this.criacao = criacao;
	}

	public TipoRecursoAula getTipoRecursoAula() {
		return tipoRecursoAula;
	}

	public void setTipoRecursoAula(TipoRecursoAula tipoRecursoAula) {
		this.tipoRecursoAula = tipoRecursoAula;
	}

	public Conteudo getConteudo() {
		return conteudo;
	}

	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}

	public Integer getOrdem() {
		return ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}

	public CentroEspirita getCentroEspirita() {
		return centroEspirita;
	}

	public void setCentroEspirita(CentroEspirita centroEspirita) {
		this.centroEspirita = centroEspirita;
	}

	public boolean isAcessoGlobal() {
		return acessoGlobal;
	}

	public void setAcessoGlobal(boolean acessoGlobal) {
		this.acessoGlobal = acessoGlobal;
	}

	@Override
	public String toString() {
		return "ItemConteudo [id=" + id + ", uuid=" + uuid + ", nome=" + nome
				+ ", descricao=" + descricao + ", linkRecurso=" + linkRecurso
				+ ", tipoRecursoAula=" + tipoRecursoAula + ", conteudo="
				+ conteudo + ", centroEspirita=" + centroEspirita + ", criacao="
				+ criacao + ", ordem=" + ordem + ", visivel=" + visivel
				+ ", acessoGlobal=" + acessoGlobal + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(acessoGlobal, centroEspirita, conteudo, criacao,
				descricao, id, linkRecurso, nome, ordem, tipoRecursoAula, uuid,
				visivel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemConteudo other = (ItemConteudo) obj;
		return acessoGlobal == other.acessoGlobal
				&& Objects.equals(centroEspirita, other.centroEspirita)
				&& Objects.equals(conteudo, other.conteudo)
				&& Objects.equals(criacao, other.criacao)
				&& Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id)
				&& Objects.equals(linkRecurso, other.linkRecurso)
				&& Objects.equals(nome, other.nome)
				&& Objects.equals(ordem, other.ordem)
				&& Objects.equals(tipoRecursoAula, other.tipoRecursoAula)
				&& Objects.equals(uuid, other.uuid) && visivel == other.visivel;
	}

}
