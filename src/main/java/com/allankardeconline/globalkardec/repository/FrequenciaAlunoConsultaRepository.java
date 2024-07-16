package com.allankardeconline.globalkardec.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.allankardeconline.globalkardec.model.visao.FrequenciaAlunoConsulta;

public interface FrequenciaAlunoConsultaRepository
		extends JpaRepository<FrequenciaAlunoConsulta, UUID> {

	@Query("SELECT o FROM FrequenciaAlunoConsulta o WHERE o.uuidTurma = :uuidTurma "
			+ " AND o.uuidDiaCalendario = :uuidDiaCalendario ORDER BY o.aluno ASC")
	List<FrequenciaAlunoConsulta> obterFrequenciasPorTurmaEDia(UUID uuidTurma,
			UUID uuidDiaCalendario);

}
