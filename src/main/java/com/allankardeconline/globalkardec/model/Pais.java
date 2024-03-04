package com.allankardeconline.globalkardec.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pais", schema = "geral")
public class Pais implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 798939850801205590L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private UUID uuid;

	@NotNull
	private String nome;

	@NotNull
	private int ddi;

	public Pais() {

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

	public int getDdi() {
		return ddi;
	}

	public void setDdi(int ddi) {
		this.ddi = ddi;
	}

	@Override
	public String toString() {
		return "Pais [id=" + id + ", uuid=" + uuid + ", nome=" + nome + ", ddi=" + ddi + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ddi, id, nome, uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		return ddi == other.ddi && Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(uuid, other.uuid);
	}

}
