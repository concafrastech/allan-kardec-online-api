package com.allankardeconline.globalkardec.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "geral", name = "notificacao_pessoa")
public class NotificacaoPessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 798939850801205590L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "data_leitura")
	private Date dataLeitura;

	@ManyToOne
	private Notificacao notificacao;

	@JoinColumn(name = "pessoa_id")
	@ManyToOne
	private Pessoa pessoa;

	public NotificacaoPessoa() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataLeitura() {
		return dataLeitura;
	}

	public void setDataLeitura(Date dataLeitura) {
		this.dataLeitura = dataLeitura;
	}

	public Notificacao getNotificacao() {
		return notificacao;
	}

	public void setNotificacao(Notificacao notificacao) {
		this.notificacao = notificacao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "NotificacaoPessoa [id=" + id + ", dataLeitura=" + dataLeitura
				+ ", notificacao=" + notificacao + ", pessoa=" + pessoa + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataLeitura, id, notificacao, pessoa);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotificacaoPessoa other = (NotificacaoPessoa) obj;
		return Objects.equals(dataLeitura, other.dataLeitura)
				&& Objects.equals(id, other.id)
				&& Objects.equals(notificacao, other.notificacao)
				&& Objects.equals(pessoa, other.pessoa);
	}

}
