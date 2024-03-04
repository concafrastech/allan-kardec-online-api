package com.allankardeconline.globalkardec.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.allankardeconline.globalkardec.model.FrequenciaAluno;

public interface FrequenciaAlunoRepository
		extends JpaRepository<FrequenciaAluno, Long> {

	@Query("SELECT o FROM FrequenciaAluno o WHERE o.diaAulaCalendario.uuid = :diaCalendario "
			+ " AND o.matricula.uuid = :matricula")
	FrequenciaAluno obterFrequenciaPorDiaEMatricula(UUID diaCalendario,
			UUID matricula);

	@Query("SELECT o FROM FrequenciaAluno o WHERE o.matricula.uuid = :matricula ORDER BY o.diaAulaCalendario.dataAula ASC")
	List<FrequenciaAluno> obterFrequenciasPorAluno(UUID matricula);

}
