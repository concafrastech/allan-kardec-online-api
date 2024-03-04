package com.allankardeconline.globalkardec.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.allankardeconline.globalkardec.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	@Query("SELECT o from Cidade o WHERE lower(o.nome) like lower(concat('%', :nome, '%')) order by o.nome ASC")
	List<Cidade> obterPorNome(String nome);

	@Query("SELECT o from Cidade o WHERE o.estado.id = :estado "
			+ " AND lower(o.nome) like lower(concat('%', :nome, '%')) order by o.nome ASC")
	List<Cidade> obterPorEstadoProvinciaENome(Long estado, String nome);
	
	@Query("SELECT o from Cidade o WHERE o.estado.id = :estado order by o.nome ASC")
	List<Cidade> obterPorEstadoProvincia(Long estado);

	Optional<Cidade> findByUuid(UUID uuid);

}
