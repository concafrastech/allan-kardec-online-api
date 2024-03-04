package com.allankardeconline.globalkardec.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.allankardeconline.globalkardec.model.visao.MatriculadosTurmaFrequenciaDiaVisao;

public interface MatriculasTurmaFrequenciaDiaRepository
		extends JpaRepository<MatriculadosTurmaFrequenciaDiaVisao, String> {

	@Query("SELECT o FROM MatriculadosTurmaFrequenciaDiaVisao o WHERE o.turma.calendario.uuid = :uuidCalendario "
			+ " AND o.diaAula.dataAula = :dataAula ORDER BY o.turma.curso.nome ASC ")
	public List<MatriculadosTurmaFrequenciaDiaVisao> obterMatriculadosPorCalendario(
			UUID uuidCalendario, LocalDate dataAula);
}
