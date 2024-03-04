package com.allankardeconline.globalkardec.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "contato", schema = "geral")
public class Contato implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 798939850801205590L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String telefone;

	private String email;

	private String facebook;

	private String instagram;

	public Contato() {

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
		return "Contato [id=" + id + ", telefone=" + telefone + ", email="
				+ email + ", facebook=" + facebook + ", instagram=" + instagram
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, facebook, id, instagram, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(email, other.email)
				&& Objects.equals(facebook, other.facebook)
				&& Objects.equals(id, other.id)
				&& Objects.equals(instagram, other.instagram)
				&& Objects.equals(telefone, other.telefone);
	}

}
