package com.allankardeconline.globalkardec.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "estado", schema = "geral")
public class EstadoProvincia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 798939850801205590L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private UUID uuid;

	private String nome;

	@JoinColumn(name = "pais_id")
	@ManyToOne
	private Pais pais;

	public EstadoProvincia() {

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

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "EstadoProvincia [id=" + id + ", uuid=" + uuid + ", nome=" + nome + ", pais=" + pais + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome, pais, uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstadoProvincia other = (EstadoProvincia) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome) && Objects.equals(pais, other.pais)
				&& Objects.equals(uuid, other.uuid);
	}

}
