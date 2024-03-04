package com.allankardeconline.globalkardec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allankardeconline.globalkardec.model.categoricos.TipoRecursoAula;

public interface TipoRecursoAulaRepository extends JpaRepository<TipoRecursoAula, Long> {

	List<TipoRecursoAula> findByNomeLikeIgnoreCase(String nome);

}
