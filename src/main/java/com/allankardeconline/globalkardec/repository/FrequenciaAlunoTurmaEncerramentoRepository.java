package com.allankardeconline.globalkardec.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.allankardeconline.globalkardec.model.visao.FrequenciaAlunoTurmaEncerramentoVisao;

public interface FrequenciaAlunoTurmaEncerramentoRepository
		extends JpaRepository<FrequenciaAlunoTurmaEncerramentoVisao, String> {

	@Query("SELECT o FROM FrequenciaAlunoTurmaEncerramentoVisao o WHERE o.turma.uuid = :uuidTurma "
			+ " ORDER BY o.turma.curso.nome ASC ")
	public List<FrequenciaAlunoTurmaEncerramentoVisao> obterFrequenciaAlunoTurmaEncerramento(
			UUID uuidTurma);

	@Query("SELECT o FROM FrequenciaAlunoTurmaEncerramentoVisao o WHERE o.turma.uuid = :uuidTurma "
			+ " AND o.matricula = :matricula")
	public FrequenciaAlunoTurmaEncerramentoVisao obterFrequenciaAlunoTurmaEncerramento(
			UUID uuidTurma, UUID matricula);
}
