package com.allankardeconline.globalkardec.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.allankardeconline.globalkardec.model.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

	Optional<Matricula> findByUuid(UUID uuid);

	@Query("SELECT o FROM Matricula o WHERE o.pessoa.uuid = :uuidPessoa order by o.dataInicio DESC")
	Page<Matricula> obterMatriculasPorPessoa(UUID uuidPessoa,
			Pageable paginacao);
	
	@Query("SELECT o FROM Matricula o WHERE o.pessoa.uuid = :uuidPessoa "
			+ " AND o.situacaoMatricula.id = :situacao order by o.dataInicio DESC")
	Page<Matricula> obterMatriculasAtivasPorPessoa(UUID uuidPessoa, Long situacao,
			Pageable paginacao);

	@Query("SELECT o FROM Matricula o WHERE LOWER(o.pessoa.nome) like LOWER(CONCAT('%',:nomePessoa,'%')) "
			+ " order by o.pessoa.nome ASC, o.dataInicio DESC")
	Page<Matricula> obterMatriculasPorNomePessoa(String nomePessoa,
			Pageable paginacao);

	@Query("SELECT o FROM Matricula o WHERE o.turma.uuid = :uuidTurma order by o.dataInicio DESC")
	Page<Matricula> obterMatriculasPorTurma(UUID uuidTurma, Pageable paginacao);

	@Query("SELECT o FROM Matricula o WHERE o.turma.uuid = :uuidTurma order by o.dataInicio DESC")
	List<Matricula> obterMatriculasPorTurma(UUID uuidTurma);

	@Query("SELECT o FROM Matricula o WHERE o.turma.uuid = :uuidTurma AND o.pessoa.uuid = :uuidPessoa")
	Matricula obterMatriculaPorTurmaEPessoa(UUID uuidTurma, UUID uuidPessoa);

}
