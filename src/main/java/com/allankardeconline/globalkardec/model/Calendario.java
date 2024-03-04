package com.allankardeconline.globalkardec.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.allankardeconline.site.model.CentroEspirita;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(schema = "globalkardec", name = "calendario")
public class Calendario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 798939850801205590L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private UUID uuid;

	@JoinColumn(name = "spiritist_center_member_id")
	@ManyToOne()
	private CentroEspirita centroEspirita;

	private Integer semestre;

	private Integer ano;

	@OneToMany(mappedBy = "calendario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DiaAulaCalendario> diasAula;

	@JoinColumn(name = "criacao_id")
	@ManyToOne(cascade = CascadeType.ALL)
	private Metadados criacao;

	public Calendario() {

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

	public List<DiaAulaCalendario> getDiasAula() {
		return diasAula;
	}

	public void setDiasAula(List<DiaAulaCalendario> diasAula) {
		this.diasAula = diasAula;
	}

	public Metadados getCriacao() {
		return criacao;
	}

	public void setCriacao(Metadados criacao) {
		this.criacao = criacao;
	}

	public CentroEspirita getCentroEspirita() {
		return centroEspirita;
	}

	public void setCentroEspirita(CentroEspirita centroEspirita) {
		this.centroEspirita = centroEspirita;
	}

	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "Calendario [id=" + id + ", uuid=" + uuid + ", centroEspirita="
				+ centroEspirita + ", semestre=" + semestre + ", ano=" + ano
				+ ", diasAula=" + diasAula + ", criacao=" + criacao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ano, centroEspirita, criacao, diasAula, id,
				semestre, uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calendario other = (Calendario) obj;
		return Objects.equals(ano, other.ano)
				&& Objects.equals(centroEspirita, other.centroEspirita)
				&& Objects.equals(criacao, other.criacao)
				&& Objects.equals(diasAula, other.diasAula)
				&& Objects.equals(id, other.id)
				&& Objects.equals(semestre, other.semestre)
				&& Objects.equals(uuid, other.uuid);
	}

}
