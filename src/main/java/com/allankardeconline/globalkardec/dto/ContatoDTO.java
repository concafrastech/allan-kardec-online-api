package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.Objects;

import jakarta.validation.constraints.NotEmpty;

public class ContatoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5864305264472641056L;

	@NotEmpty(message = "{campo.pessoa.telefone}")
	private String telefone;

	@NotEmpty(message = "{campo.pessoa.email}")
	private String email;

	private String facebook;

	private String instagram;

	public ContatoDTO() {

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

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	@Override
	public String toString() {
		return "ContatoDTO [telefone=" + telefone + ", email=" + email
				+ ", facebook=" + facebook + ", instagram=" + instagram + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, facebook, instagram, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContatoDTO other = (ContatoDTO) obj;
		return Objects.equals(email, other.email)
				&& Objects.equals(facebook, other.facebook)
				&& Objects.equals(instagram, other.instagram)
				&& Objects.equals(telefone, other.telefone);
	}

}
