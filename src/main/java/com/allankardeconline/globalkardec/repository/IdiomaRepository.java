package com.allankardeconline.globalkardec.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allankardeconline.globalkardec.model.Idioma;

public interface IdiomaRepository extends JpaRepository<Idioma, Long> {

	List<Idioma> findByNomeLikeIgnoreCase(String nome);
	
	Optional<Idioma> findByUuid(UUID uuid);

}
