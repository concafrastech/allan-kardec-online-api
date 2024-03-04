package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class SituacaoAlunoEncerramentoSemestreDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3053444865642830885L;

	private UUID matricula;

	private String aluno;

	private Integer quantidadeAulasNormais;

	private Integer quantidadePresencas;

	private Long idSituacao;

	public UUID getMatricula() {
		return matricula;
	}

	public void setMatricula(UUID matricula) {
		this.matricula = matricula;
	}

	public String getAluno() {
		return aluno;
	}

	public void setAluno(String aluno) {
		this.aluno = aluno;
	}

	public Integer getQuantidadePresencas() {
		return quantidadePresencas;
	}

	public void setQuantidadePresencas(Integer quantidadePresencas) {
		this.quantidadePresencas = quantidadePresencas;
	}

	public Long getIdSituacao() {
		return idSituacao;
	}

	public void setIdSituacao(Long idSituacao) {
		this.idSituacao = idSituacao;
	}
	
	

	public Integer getQuantidadeAulasNormais() {
		return quantidadeAulasNormais;
	}

	public void setQuantidadeAulasNormais(Integer quantidadeAulasNormais) {
		this.quantidadeAulasNormais = quantidadeAulasNormais;
	}

	@Override
	public int hashCode() {
		return Objects.hash(aluno, idSituacao, matricula, quantidadePresencas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SituacaoAlunoEncerramentoSemestreDTO other = (SituacaoAlunoEncerramentoSemestreDTO) obj;
		return Objects.equals(aluno, other.aluno)
				&& Objects.equals(idSituacao, other.idSituacao)
				&& Objects.equals(matricula, other.matricula) && Objects
						.equals(quantidadePresencas, other.quantidadePresencas);
	}

}
