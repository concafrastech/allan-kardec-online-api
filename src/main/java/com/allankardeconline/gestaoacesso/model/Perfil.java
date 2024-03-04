package com.allankardeconline.gestaoacesso.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(schema = "gestaoacesso", name = "perfil")
public class Perfil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 650659524697804953L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "perfil")
	private List<ItemPermissaoPerfil> permissoes;

	public Perfil() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ItemPermissaoPerfil> getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(List<ItemPermissaoPerfil> permissoes) {
		this.permissoes = permissoes;
	}

}
