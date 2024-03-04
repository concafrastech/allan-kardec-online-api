package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.dozermapper.core.Mapping;

import jakarta.validation.constraints.NotNull;

public class DiaAulaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1781312215293011816L;

	private UUID uuid;

	@NotNull(message = "{campo.data.obrigatorio}")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataAula;

	@Mapping(value = "tipoDiaCalendario.id")
	@NotNull(message = "{campo.tipo_dia_calendario.obrigatorio}")
	private Long idTipoDiaCalendario;

	@Mapping(value = "tipoDiaCalendario.nome")
	private String nomeTipoDiaCalendario;

	@NotNull(message = "{campo.dia_calendario_aula_especial.obrigatorio}")
	private Boolean aulaEspecial;

	public DiaAulaDTO() {

	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public LocalDate getDataAula() {
		return dataAula;
	}

	public void setDataAula(LocalDate dataAula) {
		this.dataAula = dataAula;
	}

	public Long getIdTipoDiaCalendario() {
		return idTipoDiaCalendario;
	}

	public void setIdTipoDiaCalendario(Long idTipoDiaCalendario) {
		this.idTipoDiaCalendario = idTipoDiaCalendario;
	}

	public String getNomeTipoDiaCalendario() {
		return nomeTipoDiaCalendario;
	}

	public void setNomeTipoDiaCalendario(String nomeTipoDiaCalendario) {
		this.nomeTipoDiaCalendario = nomeTipoDiaCalendario;
	}

	public Boolean getAulaEspecial() {
		return aulaEspecial;
	}

	public void setAulaEspecial(Boolean aulaEspecial) {
		this.aulaEspecial = aulaEspecial;
	}

	@Override
	public String toString() {
		return "DiaAulaDTO [uuid=" + uuid + ", dataAula=" + dataAula
				+ ", idTipoDiaCalendario=" + idTipoDiaCalendario
				+ ", nomeTipoDiaCalendario=" + nomeTipoDiaCalendario
				+ ", aulaEspecial=" + aulaEspecial + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(aulaEspecial, dataAula, idTipoDiaCalendario,
				nomeTipoDiaCalendario, uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiaAulaDTO other = (DiaAulaDTO) obj;
		return Objects.equals(aulaEspecial, other.aulaEspecial)
				&& Objects.equals(dataAula, other.dataAula)
				&& Objects.equals(idTipoDiaCalendario,
						other.idTipoDiaCalendario)
				&& Objects.equals(nomeTipoDiaCalendario,
						other.nomeTipoDiaCalendario)
				&& Objects.equals(uuid, other.uuid);
	}

	

}
