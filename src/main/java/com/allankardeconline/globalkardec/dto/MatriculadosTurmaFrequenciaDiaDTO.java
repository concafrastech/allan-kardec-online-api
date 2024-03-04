package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.github.dozermapper.core.Mapping;

public class MatriculadosTurmaFrequenciaDiaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -496859864426236862L;

	private String id;

	@Mapping(value = "turma.curso.nome")
	private String curso;

	@Mapping(value = "turma.calendario.centroEspirita.nome")
	private String centroEspirita;

	@Mapping(value = "diaAula.calendario.semestre")
	private Integer semestre;

	@Mapping(value = "diaAula.calendario.ano")
	private Integer ano;

	@Mapping(value = "diaAula.dataAula")
	private LocalDate dataAula;

	@Mapping(value = "diaAula.tipoDiaCalendario.nome")
	private String tipoData;

	private Integer matriculados;

	private Integer frequenciasRegistradas;

	public MatriculadosTurmaFrequenciaDiaDTO() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getCentroEspirita() {
		return centroEspirita;
	}

	public void setCentroEspirita(String centroEspirita) {
		this.centroEspirita = centroEspirita;
	}

	public LocalDate getDataAula() {
		return dataAula;
	}

	public void setDataAula(LocalDate dataAula) {
		this.dataAula = dataAula;
	}

	public String getTipoData() {
		return tipoData;
	}

	public void setTipoData(String tipoData) {
		this.tipoData = tipoData;
	}

	public Integer getMatriculados() {
		return matriculados;
	}

	public void setMatriculados(Integer matriculados) {
		this.matriculados = matriculados;
	}

	public Integer getFrequenciasRegistradas() {
		return frequenciasRegistradas;
	}

	public void setFrequenciasRegistradas(Integer frequenciasRegistradas) {
		this.frequenciasRegistradas = frequenciasRegistradas;
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
		return "MatriculadosTurmaFrequenciaDiaDTO [id=" + id + ", curso="
				+ curso + ", centroEspirita=" + centroEspirita + ", semestre="
				+ semestre + ", ano=" + ano + ", dataAula=" + dataAula
				+ ", tipoData=" + tipoData + ", matriculados=" + matriculados
				+ ", frequenciasRegistradas=" + frequenciasRegistradas + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ano, centroEspirita, curso, dataAula,
				frequenciasRegistradas, id, matriculados, semestre, tipoData);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatriculadosTurmaFrequenciaDiaDTO other = (MatriculadosTurmaFrequenciaDiaDTO) obj;
		return Objects.equals(ano, other.ano)
				&& Objects.equals(centroEspirita, other.centroEspirita)
				&& Objects.equals(curso, other.curso)
				&& Objects.equals(dataAula, other.dataAula)
				&& Objects.equals(frequenciasRegistradas,
						other.frequenciasRegistradas)
				&& Objects.equals(id, other.id)
				&& Objects.equals(matriculados, other.matriculados)
				&& Objects.equals(semestre, other.semestre)
				&& Objects.equals(tipoData, other.tipoData);
	}

}
