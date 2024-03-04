package com.allankardeconline.globalkardec.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.allankardeconline.globalkardec.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	Optional<Pessoa> findByUuid(UUID uuid);

	@Query("Select o FROM Pessoa o WHERE lower(o.nome) like lower(concat('%', :nome, '%')) order by o.nome ")
	Page<Pessoa> findByNomeLikeIgnoreCase(String nome, Pageable paginacao);

	@Query("SELECT o FROM Pessoa o WHERE  lower( o.contato.email) = lower(:email) OR lower(o.contato.telefone) = lower(:telefone)")
	Page<Pessoa> existeByEmailOrTelefone(String email, String telefone,
			Pageable paginacao);

	@Query("SELECT o FROM Pessoa o "
			+ " WHERE  lower( o.contato.email) = lower(:email) "
			+ " OR lower(o.contato.telefone) = lower(:telefone)")
	List<Pessoa> findByEmailOrTelefone(String email, String telefone);

	@Query("SELECT o from Pessoa o WHERE o.usuario.centroEspirita.uuid = :uuidCentro order by o.nome ASC")
	Page<Pessoa> obterTodosPorCentro(UUID uuidCentro, Pageable paginacao);

}
