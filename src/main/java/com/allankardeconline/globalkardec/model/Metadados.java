package com.allankardeconline.globalkardec.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.allankardeconline.gestaoacesso.model.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(schema = "util", name = "metadados")
public class Metadados implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 798939850801205590L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JoinColumn(name = "user_id")
	@ManyToOne
	private Usuario usuario;

	@Column(name = "data_operacao")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataOperacao;

	public Metadados() {
		dataOperacao = new Date();
	}

	public Long getId() {
		return id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataOperacao() {
		return dataOperacao;
	}

	public void setDataOperacao(Date dataOperacao) {
		this.dataOperacao = dataOperacao;
	}

	@Override
	public String toString() {
		return "Metadados [id=" + id + ", usuario=" + usuario
				+ ", dataOperacao=" + dataOperacao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataOperacao, id, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Metadados other = (Metadados) obj;
		return Objects.equals(dataOperacao, other.dataOperacao)
				&& Objects.equals(id, other.id)
				&& Objects.equals(usuario, other.usuario);
	}

}
