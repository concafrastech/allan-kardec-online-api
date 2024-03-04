package com.allankardeconline.globalkardec.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.allankardeconline.globalkardec.model.Instituto;

public interface InstitutoRepository extends JpaRepository<Instituto, Long> {

	List<Instituto> findByNomeLikeIgnoreCaseOrderByNome(String nome);

	Optional<Instituto> findByUuid(UUID uuid);

//	List<MaterialAula> findByDescricaoLike(String descricao);
//
//	@Query(value = "Select o from Produto o  where o.id = :id")
//	List<MaterialAula> obterPorNome(@Param("id") Long id);
}
