package com.allankardeconline.globalkardec.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.allankardeconline.globalkardec.model.ItemConteudo;

public interface ItemConteudoRepository
		extends JpaRepository<ItemConteudo, Long> {

	List<ItemConteudo> findByNomeLikeIgnoreCase(String nome);

	@Query("SELECT o FROM ItemConteudo o WHERE (o.acessoGlobal = true OR o.centroEspirita.uuid = :uuidCentro )"
			+ " AND o.conteudo.uuid = :uuidConteudo ORDER BY o.ordem ASC")
	List<ItemConteudo> obterTodosItensGlobaisEConteudoUuid(UUID uuidCentro,
			UUID uuidConteudo);

	Optional<ItemConteudo> findByUuid(UUID uuid);

}
