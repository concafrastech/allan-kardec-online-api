package com.allankardeconline.globalkardec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.allankardeconline.globalkardec.model.EstadoProvincia;

public interface EstadoProvinciaRepository
		extends JpaRepository<EstadoProvincia, Long> {

	@Query("SELECT o from EstadoProvincia o WHERE o.pais.id = :pais "
			+ " AND lower(o.nome) like lower(concat('%', :nome, '%')) order by o.nome ASC")
	List<EstadoProvincia> obterPorPaisENome(Long pais, String nome);

	@Query("SELECT o from EstadoProvincia o WHERE o.pais.id = :pais "
			+ " order by o.nome ASC")
	List<EstadoProvincia> obterPorPais(Long pais);
}
