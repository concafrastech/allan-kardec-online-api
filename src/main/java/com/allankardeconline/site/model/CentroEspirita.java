package com.allankardeconline.site.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import com.allankardeconline.globalkardec.model.Contato;
import com.allankardeconline.globalkardec.model.Endereco;

import jakarta.persistence.CascadeType;
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
@Table(name = "member_spiritist_center")
public class CentroEspirita implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 798939850801205590L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private UUID uuid;

	@Column(name = "name")
	private String nome;

	@Column(name = "registrationDate")
	@Temporal(TemporalType.DATE)
	private Date dataRegistro;

	@JoinColumn(name = "address_id")
	@ManyToOne(cascade = CascadeType.ALL)
	private Endereco endereco;

	@JoinColumn(name = "contact_id")
	@ManyToOne(cascade = CascadeType.ALL)
	private Contato contato;

	@Column(name = "foundation")
	private String fundacao;

	@Column(name = "responsible")
	private String responsavel;

	private String latitude;

	private String longitude;

	@Column(name = "inactive")
	private int ativo;

	@Column(name = "location", columnDefinition = "text")
	private String localizacao;

	public CentroEspirita() {

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

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public String getFundacao() {
		return fundacao;
	}

	public void setFundacao(String fundacao) {
		this.fundacao = fundacao;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	@Override
	public String toString() {
		return "CentroEspirita [id=" + id + ", uuid=" + uuid + ", nome=" + nome
				+ ", dataRegistro=" + dataRegistro + ", endereco=" + endereco
				+ ", contato=" + contato + ", fundacao=" + fundacao
				+ ", responsavel=" + responsavel + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", ativo=" + ativo
				+ ", localizacao=" + localizacao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ativo, contato, dataRegistro, endereco, fundacao,
				id, latitude, localizacao, longitude, nome, responsavel, uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CentroEspirita other = (CentroEspirita) obj;
		return ativo == other.ativo && Objects.equals(contato, other.contato)
				&& Objects.equals(dataRegistro, other.dataRegistro)
				&& Objects.equals(endereco, other.endereco)
				&& Objects.equals(fundacao, other.fundacao)
				&& Objects.equals(id, other.id)
				&& Objects.equals(latitude, other.latitude)
				&& Objects.equals(localizacao, other.localizacao)
				&& Objects.equals(longitude, other.longitude)
				&& Objects.equals(nome, other.nome)
				&& Objects.equals(responsavel, other.responsavel)
				&& Objects.equals(uuid, other.uuid);
	}

}
