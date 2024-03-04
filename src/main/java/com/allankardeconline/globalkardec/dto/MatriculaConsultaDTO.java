package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import com.github.dozermapper.core.Mapping;

public class MatriculaConsultaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4380096125023939897L;

	@Mapping(value = "id")
	private Long numeroMatricula;

	private UUID uuid;

	private PessoaResumidoDTO pessoa;

	private LocalDate dataInicio;

	private LocalDate dataEncerramento;

	@Mapping(value = "vinculoMatricula.nome")
	private String nomeVinculoMatricula;

	@Mapping(value = "situacaoMatricula.nome")
	private String nomeSituacaoMatricula;

	private TurmaDTO turma;

	public MatriculaConsultaDTO() {

	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public PessoaResumidoDTO getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaResumidoDTO pessoa) {
		this.pessoa = pessoa;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(LocalDate dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}

	public String getNomeVinculoMatricula() {
		return nomeVinculoMatricula;
	}

	public void setNomeVinculoMatricula(String nomeVinculoMatricula) {
		this.nomeVinculoMatricula = nomeVinculoMatricula;
	}

	public String getNomeSituacaoMatricula() {
		return nomeSituacaoMatricula;
	}

	public void setNomeSituacaoMatricula(String nomeSituacaoMatricula) {
		this.nomeSituacaoMatricula = nomeSituacaoMatricula;
	}

	public TurmaDTO getTurma() {
		return turma;
	}

	public void setTurma(TurmaDTO turma) {
		this.turma = turma;
	}

	public Long getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(Long numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	@Override
	public String toString() {
		return "MatriculaConsultaDTO [numeroMatricula=" + numeroMatricula
				+ ", uuid=" + uuid + ", pessoa=" + pessoa + ", dataInicio="
				+ dataInicio + ", dataEncerramento=" + dataEncerramento
				+ ", nomeVinculoMatricula=" + nomeVinculoMatricula
				+ ", nomeSituacaoMatricula=" + nomeSituacaoMatricula
				+ ", turma=" + turma + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataEncerramento, dataInicio, nomeSituacaoMatricula,
				nomeVinculoMatricula, numeroMatricula, pessoa, turma, uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatriculaConsultaDTO other = (MatriculaConsultaDTO) obj;
		return Objects.equals(dataEncerramento, other.dataEncerramento)
				&& Objects.equals(dataInicio, other.dataInicio)
				&& Objects.equals(nomeSituacaoMatricula,
						other.nomeSituacaoMatricula)
				&& Objects.equals(nomeVinculoMatricula,
						other.nomeVinculoMatricula)
				&& Objects.equals(numeroMatricula, other.numeroMatricula)
				&& Objects.equals(pessoa, other.pessoa)
				&& Objects.equals(turma, other.turma)
				&& Objects.equals(uuid, other.uuid);
	}

}
