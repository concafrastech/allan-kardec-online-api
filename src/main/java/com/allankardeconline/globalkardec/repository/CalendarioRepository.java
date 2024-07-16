package com.allankardeconline.globalkardec.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.allankardeconline.globalkardec.model.Calendario;

public interface CalendarioRepository extends JpaRepository<Calendario, Long> {

	Optional<Calendario> findByUuid(UUID uuid);
	
	List<Calendario> findAll();

	@Query("SELECT o from Calendario o WHERE o.centroEspirita.uuid = :uuidCentro order by o.id DESC")
	List<Calendario> obterTodosPorCentro(UUID uuidCentro);

	@Query("SELECT CASE WHEN (count(o)>0) THEN true ELSE false END from Calendario o "
			+ " WHERE o.centroEspirita.uuid = :uuidCentro "
			+ "AND o.semestre = :semestre AND o.ano = :ano ")
	boolean existePorCentroAndSemestreAndAno(UUID uuidCentro, int semestre,
			int ano); 
}
