package com.allankardeconline.globalkardec.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "configuracao_global_kardec", schema = "globalkardec")
public class ConfiguracaoGlobalKardec implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 650659524697804953L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JoinColumn(name = "turma_id")
	@ManyToOne
	private Turma turmaMatriculaInicial;

	@JoinColumn(name = "alteracao_id")
	@ManyToOne(cascade = CascadeType.ALL)
	private Metadados alteracao;

	public ConfiguracaoGlobalKardec() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Turma getTurmaMatriculaInicial() {
		return turmaMatriculaInicial;
	}

	public void setTurmaMatriculaInicial(Turma turmaMatriculaInicial) {
		this.turmaMatriculaInicial = turmaMatriculaInicial;
	}

	public Metadados getAlteracao() {
		return alteracao;
	}

	public void setAlteracao(Metadados alteracao) {
		this.alteracao = alteracao;
	}

	@Override
	public String toString() {
		return "ConfiguracaoGlobalKardec [id=" + id + ", turmaMatriculaInicial="
				+ turmaMatriculaInicial + ", alteracao=" + alteracao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(alteracao, id, turmaMatriculaInicial);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConfiguracaoGlobalKardec other = (ConfiguracaoGlobalKardec) obj;
		return Objects.equals(alteracao, other.alteracao)
				&& Objects.equals(id, other.id) && Objects.equals(
						turmaMatriculaInicial, other.turmaMatriculaInicial);
	}

}
