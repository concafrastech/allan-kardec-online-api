package com.allankardeconline.globalkardec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allankardeconline.globalkardec.model.categoricos.TipoCurso;

public interface TipoCursoRepository extends JpaRepository<TipoCurso, Long> {

	List<TipoCurso> findByNomeLikeIgnoreCase(String nome);

}
