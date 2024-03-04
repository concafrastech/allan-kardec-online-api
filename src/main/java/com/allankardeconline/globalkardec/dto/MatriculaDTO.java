package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

import com.github.dozermapper.core.Mapping;

import jakarta.validation.constraints.NotNull;

public class MatriculaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4380096125023939897L;

	private UUID uuid;

	@NotNull(message = "{campo.pessoa.obrigatorio}")
	private PessoaResumidoDTO pessoa;

	@NotNull(message = "{campo.data_inicio.obrigatorio}")
	private LocalDate dataInicio;

	private LocalDate dataEncerramento;

	@Mapping(value = "vinculoMatricula.id")
	@NotNull(message = "{campo.vinculo.obrigatorio}")
	private Long vinculoMatricula;

	@Mapping(value = "vinculoMatricula.nome")
	private String nomeVinculoMatricula;

	@Mapping(value = "situacaoMatricula.id")
	private Long situacaoMatricula;

	@Mapping(value = "situacaoMatricula.nome")
	private String nomeSituacaoMatricula;

	private TurmaDTO turma;

	private String observacao;

	public MatriculaDTO() {

	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
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

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Long getVinculoMatricula() {
		return vinculoMatricula;
	}

	public void setVinculoMatricula(Long vinculoMatricula) {
		this.vinculoMatricula = vinculoMatricula;
	}

	public Long getSituacaoMatricula() {
		return situacaoMatricula;
	}

	public void setSituacaoMatricula(Long situacaoMatricula) {
		this.situacaoMatricula = situacaoMatricula;
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

	public PessoaResumidoDTO getPessoa() {
		return pessoa;
	}

	public void setPessoa(PessoaResumidoDTO pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public String toString() {
		return "MatriculaDTO [uuid=" + uuid + ", pessoa=" + pessoa
				+ ", dataInicio=" + dataInicio + ", dataEncerramento="
				+ dataEncerramento + ", vinculoMatricula=" + vinculoMatricula
				+ ", nomeVinculoMatricula=" + nomeVinculoMatricula
				+ ", situacaoMatricula=" + situacaoMatricula
				+ ", nomeSituacaoMatricula=" + nomeSituacaoMatricula
				+ ", turma=" + turma + ", observacao=" + observacao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataEncerramento, dataInicio, nomeSituacaoMatricula,
				nomeVinculoMatricula, observacao, pessoa, situacaoMatricula,
				turma, uuid, vinculoMatricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MatriculaDTO other = (MatriculaDTO) obj;
		return Objects.equals(dataEncerramento, other.dataEncerramento)
				&& Objects.equals(dataInicio, other.dataInicio)
				&& Objects.equals(nomeSituacaoMatricula,
						other.nomeSituacaoMatricula)
				&& Objects.equals(nomeVinculoMatricula,
						other.nomeVinculoMatricula)
				&& Objects.equals(observacao, other.observacao)
				&& Objects.equals(pessoa, other.pessoa)
				&& Objects.equals(situacaoMatricula, other.situacaoMatricula)
				&& Objects.equals(turma, other.turma)
				&& Objects.equals(uuid, other.uuid)
				&& Objects.equals(vinculoMatricula, other.vinculoMatricula);
	}

}
