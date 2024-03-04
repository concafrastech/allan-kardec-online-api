package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.validation.constraints.NotEmpty;

public class PreCadastroDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 798939850801205590L;

	private Long id;

	@NotEmpty(message = "campo.nome.obrigatorio")
	private String nome;

	@NotEmpty(message = "campo.pessoa.telefone")
	private String telefone;

	@NotEmpty(message = "campo.pessoa.email")
	private String email;

	@NotEmpty(message = "campo.pre_cadastro.campanha")
	private String campanha;

	private Date dataInclusao;

	public PreCadastroDTO() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCampanha() {
		return campanha;
	}

	public void setCampanha(String campanha) {
		this.campanha = campanha;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	@Override
	public String toString() {
		return "PreCadastroDTO [id=" + id + ", nome=" + nome + ", telefone="
				+ telefone + ", email=" + email + ", campanha=" + campanha
				+ ", dataInclusao=" + dataInclusao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(campanha, dataInclusao, email, id, nome, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PreCadastroDTO other = (PreCadastroDTO) obj;
		return Objects.equals(campanha, other.campanha)
				&& Objects.equals(dataInclusao, other.dataInclusao)
				&& Objects.equals(email, other.email)
				&& Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome)
				&& Objects.equals(telefone, other.telefone);
	}

}
