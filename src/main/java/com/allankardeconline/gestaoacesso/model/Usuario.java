package com.allankardeconline.gestaoacesso.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import com.allankardeconline.site.model.CentroEspirita;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario", schema = "gestaoacesso")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 798939850801205590L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private UUID uuid;

	@Column(name = "login_email")
	private String loginEmail;

	@Column(name = "login_telefone")
	private String loginTelefone;

	@Column(name = "login_google")
	private String loginGoogle;

	@Column(name = "senha")
	private String senha;

	@JoinColumn(name = "member_spiritist_center_id")
	@ManyToOne
	private CentroEspirita centroEspirita;
	
	

	public Usuario() {

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

	public String getLoginEmail() {
		return loginEmail;
	}

	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	public String getLoginTelefone() {
		return loginTelefone;
	}

	public void setLoginTelefone(String loginTelefone) {
		this.loginTelefone = loginTelefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public CentroEspirita getCentroEspirita() {
		return centroEspirita;
	}

	public void setCentroEspirita(CentroEspirita centroEspirita) {
		this.centroEspirita = centroEspirita;
	}

	public String getLoginGoogle() {
		return loginGoogle;
	}

	public void setLoginGoogle(String loginGoogle) {
		this.loginGoogle = loginGoogle;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", uuid=" + uuid + ", loginEmail="
				+ loginEmail + ", loginTelefone=" + loginTelefone
				+ ", loginGoogle=" + loginGoogle + ", senha=" + senha
				+ ", centroEspirita=" + centroEspirita + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(centroEspirita, id, loginEmail, loginGoogle,
				loginTelefone, senha, uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(centroEspirita, other.centroEspirita)
				&& Objects.equals(id, other.id)
				&& Objects.equals(loginEmail, other.loginEmail)
				&& Objects.equals(loginGoogle, other.loginGoogle)
				&& Objects.equals(loginTelefone, other.loginTelefone)
				&& Objects.equals(senha, other.senha)
				&& Objects.equals(uuid, other.uuid);
	}

}
