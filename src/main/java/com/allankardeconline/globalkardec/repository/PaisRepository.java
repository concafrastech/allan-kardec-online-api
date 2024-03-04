package com.allankardeconline.globalkardec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.allankardeconline.globalkardec.model.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long> {

	List<Pais> findByNomeLikeIgnoreCase(String nome);
	
	
	@Query("SELECT o from Pais o WHERE lower(o.nome) like lower(concat('%', :nome, '%')) order by o.nome ASC")
	List<Pais> obterPorNome(String nome);

}
