package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public class MigracaoAlunosTurmaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1648240644724105097L;

	@NotNull(message = "{campo.migracao_turma.originaria.obrigatorio}")
	private UUID uuidTurmaOriginal;

	@NotNull(message = "{campo.migracao_turma.destino_aprovados.obrigatorio}")
	private UUID uuidTurmaDestinoAprovados;

	@NotNull(message = "{campo.migracao_turma.destino_reprovados.obrigatorio}")
	private UUID uuidTurmaDestinoReprovados;

	public MigracaoAlunosTurmaDTO() {

	}

	public UUID getUuidTurmaOriginal() {
		return uuidTurmaOriginal;
	}

	public void setUuidTurmaOriginal(UUID uuidTurmaOriginal) {
		this.uuidTurmaOriginal = uuidTurmaOriginal;
	}

	public UUID getUuidTurmaDestinoAprovados() {
		return uuidTurmaDestinoAprovados;
	}

	public void setUuidTurmaDestinoAprovados(UUID uuidTurmaDestinoAprovados) {
		this.uuidTurmaDestinoAprovados = uuidTurmaDestinoAprovados;
	}

	public UUID getUuidTurmaDestinoReprovados() {
		return uuidTurmaDestinoReprovados;
	}

	public void setUuidTurmaDestinoReprovados(UUID uuidTurmaDestinoReprovados) {
		this.uuidTurmaDestinoReprovados = uuidTurmaDestinoReprovados;
	}

	@Override
	public String toString() {
		return "MigracaoAlunosTurmaDTO [uuidTurmaOriginal=" + uuidTurmaOriginal
				+ ", uuidTurmaDestinoAprovados=" + uuidTurmaDestinoAprovados
				+ ", uuidTurmaDestinoReprovados=" + uuidTurmaDestinoReprovados
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuidTurmaDestinoAprovados,
				uuidTurmaDestinoReprovados, uuidTurmaOriginal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MigracaoAlunosTurmaDTO other = (MigracaoAlunosTurmaDTO) obj;
		return Objects.equals(uuidTurmaDestinoAprovados,
				other.uuidTurmaDestinoAprovados)
				&& Objects.equals(uuidTurmaDestinoReprovados,
						other.uuidTurmaDestinoReprovados)
				&& Objects.equals(uuidTurmaOriginal, other.uuidTurmaOriginal);
	}

}
