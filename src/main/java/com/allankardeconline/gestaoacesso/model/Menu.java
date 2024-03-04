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
@Table(schema = "gestaoacesso", name = "menu")
public class Menu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 650659524697804953L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	@ManyToOne
	private Menu menuSuperior;

	public Menu() {

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

	public Menu getMenuSuperior() {
		return menuSuperior;
	}

	public void setMenuSuperior(Menu menuSuperior) {
		this.menuSuperior = menuSuperior;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", nome=" + nome + ", menuSuperior="
				+ menuSuperior + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, menuSuperior, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Menu other = (Menu) obj;
		return Objects.equals(id, other.id)
				&& Objects.equals(menuSuperior, other.menuSuperior)
				&& Objects.equals(nome, other.nome);
	}

}
