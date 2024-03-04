package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.Objects;

public class EstadoProvinciaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3383421923915184499L;

	private Long id;

	private String nome;

	private PaisDTO pais;

	public EstadoProvinciaDTO() {

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

	public PaisDTO getPais() {
		return pais;
	}

	public void setPais(PaisDTO pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "EstadoProvinciaDTO [id=" + id + ", nome=" + nome + ", pais="
				+ pais + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, pais);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstadoProvinciaDTO other = (EstadoProvinciaDTO) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(pais, other.pais);
	}

	
}
