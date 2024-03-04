package com.allankardeconline.globalkardec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allankardeconline.globalkardec.model.categoricos.VinculoMatricula;

public interface VinculoMatriculaRepository extends JpaRepository<VinculoMatricula, Long> {

	List<VinculoMatricula> findByNomeLikeIgnoreCase(String nome);
	
	

}
