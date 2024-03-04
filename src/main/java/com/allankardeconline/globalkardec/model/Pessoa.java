package com.allankardeconline.globalkardec.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import com.allankardeconline.gestaoacesso.model.Usuario;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoa", schema = "geral")
public class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 798939850801205590L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private UUID uuid;

	private String nome;

	private LocalDate dataNascimento;

	@JoinColumn(name = "contato_id")
	@ManyToOne(cascade = CascadeType.ALL)
	private Contato contato;

	@JoinColumn(name = "endereco_id")
	@ManyToOne(cascade = CascadeType.ALL)
	private Endereco endereco;

	@JoinColumn(name = "idioma_id")
	@ManyToOne
	private Idioma idioma;

	@JoinColumn(name = "usuario_id")
	@ManyToOne(cascade = CascadeType.ALL)
	private Usuario usuario;

	public Pessoa() {

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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", uuid=" + uuid + ", nome=" + nome
				+ ", dataNascimento=" + dataNascimento + ", contato=" + contato
				+ ", endereco=" + endereco + ", idioma=" + idioma + ", usuario="
				+ usuario + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(contato, dataNascimento, endereco, id, idioma, nome,
				usuario, uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(contato, other.contato)
				&& Objects.equals(dataNascimento, other.dataNascimento)
				&& Objects.equals(endereco, other.endereco)
				&& Objects.equals(id, other.id)
				&& Objects.equals(idioma, other.idioma)
				&& Objects.equals(nome, other.nome)
				&& Objects.equals(usuario, other.usuario)
				&& Objects.equals(uuid, other.uuid);
	}

}
