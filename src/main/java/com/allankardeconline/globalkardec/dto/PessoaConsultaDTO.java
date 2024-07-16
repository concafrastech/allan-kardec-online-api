package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.dozermapper.core.Mapping;

import jakarta.validation.constraints.NotEmpty;

public class PessoaConsultaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3643060288918166563L;

	private UUID uuid;

	@NotEmpty(message = "{campo.centro_espirita.obrigatorio}")
	@Mapping(value = "usuario.centroEspirita.uuid")
	private UUID uuidCentro;

	@NotEmpty(message = "{campo.pessoa.nome}")
	private String nome;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;

	@Mapping(value = "contato.email")
	private String email;

	@Mapping(value = "contato.telefone")
	private String telefone;

	@Mapping(value = "endereco.cidade.nome")
	private String cidade;

	@Mapping(value = "endereco.cidade.estado.nome")
	private String estadoProvincia;

	@Mapping(value = "endereco.cidade.estado.pais.nome")
	private String pais;

	public PessoaConsultaDTO() {

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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public UUID getUuidCentro() {
		return uuidCentro;
	}

	public void setUuidCentro(UUID uuidCentro) {
		this.uuidCentro = uuidCentro;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstadoProvincia() {
		return estadoProvincia;
	}

	public void setEstadoProvincia(String estadoProvincia) {
		this.estadoProvincia = estadoProvincia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cidade, dataNascimento, email, estadoProvincia,
				nome, pais, telefone, uuid, uuidCentro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaConsultaDTO other = (PessoaConsultaDTO) obj;
		return Objects.equals(cidade, other.cidade)
				&& Objects.equals(dataNascimento, other.dataNascimento)
				&& Objects.equals(email, other.email)
				&& Objects.equals(estadoProvincia, other.estadoProvincia)
				&& Objects.equals(nome, other.nome)
				&& Objects.equals(pais, other.pais)
				&& Objects.equals(telefone, other.telefone)
				&& Objects.equals(uuid, other.uuid)
				&& Objects.equals(uuidCentro, other.uuidCentro);
	}

	@Override
	public String toString() {
		return "PessoaConsultaDTO [uuid=" + uuid + ", uuidCentro=" + uuidCentro
				+ ", nome=" + nome + ", dataNascimento=" + dataNascimento
				+ ", email=" + email + ", telefone=" + telefone + ", cidade="
				+ cidade + ", estadoProvincia=" + estadoProvincia + ", pais="
				+ pais + "]";
	}

}
