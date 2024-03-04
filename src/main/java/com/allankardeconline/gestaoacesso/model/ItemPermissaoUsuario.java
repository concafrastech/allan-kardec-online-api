package com.allankardeconline.gestaoacesso.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "gestaoacesso", name = "item_permissao_usuario")
public class ItemPermissaoUsuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 650659524697804953L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Usuario usuario;

	@ManyToOne
	private Permissao permissao;

	public ItemPermissaoUsuario() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

	@Override
	public String toString() {
		return "ItemPermissaoUsuario [id=" + id + ", usuario=" + usuario
				+ ", permissao=" + permissao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, permissao, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPermissaoUsuario other = (ItemPermissaoUsuario) obj;
		return Objects.equals(id, other.id)
				&& Objects.equals(permissao, other.permissao)
				&& Objects.equals(usuario, other.usuario);
	}

}
