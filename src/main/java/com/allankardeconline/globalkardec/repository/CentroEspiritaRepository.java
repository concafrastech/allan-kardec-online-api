package com.allankardeconline.globalkardec.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allankardeconline.site.model.CentroEspirita;

public interface CentroEspiritaRepository extends JpaRepository<CentroEspirita, Long> {

	List<CentroEspirita> findByNomeLikeIgnoreCase(String nome);
	
	List<CentroEspirita> findByNomeLikeIgnoreCaseOrderByNome(String nome);

	Optional<CentroEspirita> findByUuid(UUID uuid);

}
