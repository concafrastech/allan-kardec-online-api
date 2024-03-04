package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;

public class MatriculaDesistenciaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4380096125023939897L;

	@NotNull(message = "{campo.matricula.obrigatorio}")
	private UUID uuid;

	@NotNull(message = "{campo.data.obrigatorio}")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date data;

	public MatriculaDesistenciaDTO() {

	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "MatriculaDesistenciaDTO [uuid=" + uuid + ", data=" + data + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatriculaDesistenciaDTO other = (MatriculaDesistenciaDTO) obj;
		return Objects.equals(data, other.data)
				&& Objects.equals(uuid, other.uuid);
	}

}
