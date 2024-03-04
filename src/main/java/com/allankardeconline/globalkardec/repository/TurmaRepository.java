package com.allankardeconline.globalkardec.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.allankardeconline.globalkardec.model.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long> {

	Optional<Turma> findByUuid(UUID uuid);

	@Query("SELECT o from Turma o WHERE o.calendario.centroEspirita.uuid = :uuidCentro "
			+ " order by o.id, o.curso.nome ASC")
	Page<Turma> obterTodosPorCentro(UUID uuidCentro, Pageable paginacao);

	@Query("SELECT o from Turma o WHERE o.calendario.centroEspirita.uuid = :uuidCentro"
			+ " AND lower(o.curso.nome) like lower(concat('%', :curso,'%'))")
	Page<Turma> obterPorCentroENomeCurso(UUID uuidCentro, String curso, Pageable paginacao);
	

}
