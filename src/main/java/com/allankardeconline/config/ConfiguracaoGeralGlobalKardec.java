package com.allankardeconline.config;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfiguracaoGeralGlobalKardec {

	@Value("${ceoak.codigo-padrao}")
	private String uuidCeoak;

	@Value("${ceoak.vinculo-aluno}")
	private Long idMatriculaVinculoAluno;
	
	@Value("${ceoak.situacao-matriculado}")
	private Long idSituacaoMatriculado;

	public String getUuidCeoak() {
		return uuidCeoak;
	}

	public void setUuidCeoak(String uuidCeoak) {
		this.uuidCeoak = uuidCeoak;
	}

	public Long getIdMatriculaVinculoAluno() {
		return idMatriculaVinculoAluno;
	}

	public void setIdMatriculaVinculoAluno(Long idMatriculaVinculoAluno) {
		this.idMatriculaVinculoAluno = idMatriculaVinculoAluno;
	}

	public Long getIdSituacaoMatriculado() {
		return idSituacaoMatriculado;
	}

	public void setIdSituacaoMatriculado(Long idSituacaoMatriculado) {
		this.idSituacaoMatriculado = idSituacaoMatriculado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idMatriculaVinculoAluno, idSituacaoMatriculado,
				uuidCeoak);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConfiguracaoGeralGlobalKardec other = (ConfiguracaoGeralGlobalKardec) obj;
		return Objects.equals(idMatriculaVinculoAluno,
				other.idMatriculaVinculoAluno)
				&& Objects.equals(idSituacaoMatriculado,
						other.idSituacaoMatriculado)
				&& Objects.equals(uuidCeoak, other.uuidCeoak);
	}

		
}
