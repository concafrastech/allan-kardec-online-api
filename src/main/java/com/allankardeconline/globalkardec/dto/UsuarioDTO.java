package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class UsuarioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3552821150048096029L;

	private UUID uuid;

	private String loginEmail;

	private String loginTelefone;

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

	@Override
	public String toString() {
		return "UsuarioDTO [uuid=" + uuid + ", loginEmail=" + loginEmail
				+ ", loginTelefone=" + loginTelefone + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(loginEmail, loginTelefone, uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioDTO other = (UsuarioDTO) obj;
		return Objects.equals(loginEmail, other.loginEmail)
				&& Objects.equals(loginTelefone, other.loginTelefone)
				&& Objects.equals(uuid, other.uuid);
	}

}
