package com.allankardeconline.globalkardec.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.allankardeconline.globalkardec.model.Conteudo;

public interface ConteudoRepository extends JpaRepository<Conteudo, Long> {

	List<Conteudo> findByNomeLikeIgnoreCase(String nome);

	@Query("SELECT o FROM Conteudo o WHERE o.curso.uuid = :uuidCurso ORDER BY o.ordem ASC")
	List<Conteudo> getAllByCursoUuid(UUID uuidCurso);

	Optional<Conteudo> findByUuid(UUID uuid);

}
