package com.allankardeconline.globalkardec.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import com.allankardeconline.globalkardec.model.Curso;
import com.allankardeconline.globalkardec.model.Pessoa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class PessoaRepositoryCustomizado {

	@PersistenceContext
	private EntityManager em;

	public List<Pessoa> obterPorCentroENomeOuEmailOuTelefone(UUID uuidCentro,
			String campoBusca) {

		StringBuilder sql = new StringBuilder("SELECT o From Pessoa o "
				+ " WHERE o.centroEspirita.uuid = :uuidCentro ");

		if (!ObjectUtils.isEmpty(campoBusca)) {

			sql.append(" AND (");
			sql.append(
					" lower(o.nome) like lower(concat('%', :consulta , '%')) ");
			sql.append(
					" OR lower(o.contato.email) like lower(concat('%', :consulta, '%'))");
			sql.append(
					" OR lower(o.contato.telefone) like lower(concat('%', :consulta , '%')) ");
			sql.append(" ) ");

		}

		Query query = em.createQuery(sql.toString(), Curso.class);
		query.setParameter("uuidCentro", uuidCentro);

		if (!ObjectUtils.isEmpty(campoBusca)) {
			query.setParameter("consulta", campoBusca.toLowerCase());
		}

		List<Pessoa> pessoas = query.getResultList();

		return pessoas;

	}

}
