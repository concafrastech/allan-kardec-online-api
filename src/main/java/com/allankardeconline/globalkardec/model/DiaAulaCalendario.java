package com.allankardeconline.globalkardec.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import com.allankardeconline.globalkardec.model.categoricos.TipoDiaCalendario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(schema = "globalkardec", name = "dia_aula_calendario")
public class DiaAulaCalendario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 798939850801205590L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private UUID uuid;

	@NotNull(message = "{campo.data.obrigatorio}")
	@Temporal(TemporalType.DATE)
	private LocalDate dataAula;

	@ManyToOne
	private Calendario calendario;

	@JoinColumn(name = "tipo_dia_calendario_id")
	@ManyToOne
	private TipoDiaCalendario tipoDiaCalendario;

	private Boolean aulaEspecial;

	public DiaAulaCalendario() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getDataAula() {
		return dataAula;
	}

	public void setDataAula(LocalDate dataAula) {
		this.dataAula = dataAula;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public Calendario getCalendario() {
		return calendario;
	}

	public void setCalendario(Calendario calendario) {
		this.calendario = calendario;
	}

	public TipoDiaCalendario getTipoDiaCalendario() {
		return tipoDiaCalendario;
	}

	public void setTipoDiaCalendario(TipoDiaCalendario tipoDiaCalendario) {
		this.tipoDiaCalendario = tipoDiaCalendario;
	}

	public Boolean getAulaEspecial() {
		return aulaEspecial;
	}

	public void setAulaEspecial(Boolean aulaEspecial) {
		this.aulaEspecial = aulaEspecial;
	}

}
