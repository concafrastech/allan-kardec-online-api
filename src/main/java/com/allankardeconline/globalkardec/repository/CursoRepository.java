package com.allankardeconline.globalkardec.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.allankardeconline.globalkardec.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Page<Curso> findByNomeLikeIgnoreCase(String nome, Pageable paginacao);

	Optional<Curso> findByUuid(UUID uuid);

}
