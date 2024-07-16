package com.allankardeconline.globalkardec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allankardeconline.globalkardec.model.categoricos.SituacaoFrequencia;

public interface SituacaoFrequenciaRepository extends JpaRepository<SituacaoFrequencia, Long> {

	List<SituacaoFrequencia> findByNomeLikeIgnoreCase(String nome);
	
}
