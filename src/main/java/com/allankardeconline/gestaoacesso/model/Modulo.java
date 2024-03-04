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
@Table(schema = "gestaoacesso", name = "modulo")
public class Modulo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 650659524697804953L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String icone;

	private String url;

	@ManyToOne
	private Aplicativo aplicativo;

	@ManyToOne
	private Menu menu;

	public Modulo() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIcone() {
		return icone;
	}

	public void setIcone(String icone) {
		this.icone = icone;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Aplicativo getAplicativo() {
		return aplicativo;
	}

	public void setAplicativo(Aplicativo aplicativo) {
		this.aplicativo = aplicativo;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	@Override
	public String toString() {
		return "Modulo [id=" + id + ", nome=" + nome + ", icone=" + icone
				+ ", url=" + url + ", aplicativo=" + aplicativo + ", menu="
				+ menu + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(aplicativo, icone, id, menu, nome, url);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modulo other = (Modulo) obj;
		return Objects.equals(aplicativo, other.aplicativo)
				&& Objects.equals(icone, other.icone)
				&& Objects.equals(id, other.id)
				&& Objects.equals(menu, other.menu)
				&& Objects.equals(nome, other.nome)
				&& Objects.equals(url, other.url);
	}

}
