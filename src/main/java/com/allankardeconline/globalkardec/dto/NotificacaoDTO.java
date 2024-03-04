package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.validation.constraints.NotEmpty;

public class NotificacaoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8670027140460280424L;

	private Long id;

	private UUID uuid;

	@NotEmpty(message = "{campo.assunto.obrigatorio}")
	private String assunto;

	@NotEmpty(message = "{campo.descricao.obrigatorio}")
	private String descricao;

	public NotificacaoDTO() {

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

	@Override
	public String toString() {
		return "NotificacaoDTO [id=" + id + ", uuid=" + uuid + ", assunto=" + assunto + ", descricao=" + descricao
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(assunto, descricao, id, uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotificacaoDTO other = (NotificacaoDTO) obj;
		return Objects.equals(assunto, other.assunto) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id) && Objects.equals(uuid, other.uuid);
	}

}
