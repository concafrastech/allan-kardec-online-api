package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.dozermapper.core.Mapping;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class PessoaCadastroDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3643060288918166563L;

	private UUID uuid;

	@NotNull(message = "{campo.centro_espirita.obrigatorio}")
	private UUID uuidCentro;

	@NotEmpty(message = "{campo.pessoa.nome}")
	private String nome;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;

	@NotNull(message = "{campo.pessoa.contato}")
	private ContatoDTO contato;

	@NotNull(message = "{campo.pessoa.endereco}")
	private EnderecoCadastroDTO endereco;

	@NotNull(message = "{campo.idioma.obrigatorio}")
	@Mapping(value = "idioma.uuid")
	private UUID idioma;

	public PessoaCadastroDTO() {

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public UUID getIdioma() {
		return idioma;
	}

	public void setIdioma(UUID idioma) {
		this.idioma = idioma;
	}

	public ContatoDTO getContato() {
		return contato;
	}

	public void setContato(ContatoDTO contato) {
		this.contato = contato;
	}

	public EnderecoCadastroDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoCadastroDTO endereco) {
		this.endereco = endereco;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public UUID getUuidCentro() {
		return uuidCentro;
	}

	public void setUuidCentro(UUID uuidCentro) {
		this.uuidCentro = uuidCentro;
	}

	@Override
	public String toString() {
		return "PessoaCadastroDTO [uuid=" + uuid + ", uuidCentro=" + uuidCentro
				+ ", nome=" + nome + ", dataNascimento=" + dataNascimento
				+ ", contato=" + contato + ", endereco=" + endereco
				+ ", idioma=" + idioma + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(contato, dataNascimento, endereco, idioma, nome,
				uuid, uuidCentro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaCadastroDTO other = (PessoaCadastroDTO) obj;
		return Objects.equals(contato, other.contato)
				&& Objects.equals(dataNascimento, other.dataNascimento)
				&& Objects.equals(endereco, other.endereco)
				&& Objects.equals(idioma, other.idioma)
				&& Objects.equals(nome, other.nome)
				&& Objects.equals(uuid, other.uuid)
				&& Objects.equals(uuidCentro, other.uuidCentro);
	}

}
