package com.allankardeconline.globalkardec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allankardeconline.globalkardec.model.categoricos.SituacaoMatricula;

public interface SituacaoMatriculaRepository extends JpaRepository<SituacaoMatricula, Long> {

	List<SituacaoMatricula> findByNomeLikeIgnoreCase(String nome);

}
