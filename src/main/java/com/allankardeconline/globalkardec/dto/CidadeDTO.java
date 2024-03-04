package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.Objects;

public class CidadeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6538460830069298730L;

	private Long id;

	private String nome;

	private EstadoProvinciaDTO estado;

	public CidadeDTO() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EstadoProvinciaDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoProvinciaDTO estado) {
		this.estado = estado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "CidadeDTO [id=" + id + ", nome=" + nome + ", estado=" + estado
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(estado, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CidadeDTO other = (CidadeDTO) obj;
		return Objects.equals(estado, other.estado)
				&& Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome);
	}

}
