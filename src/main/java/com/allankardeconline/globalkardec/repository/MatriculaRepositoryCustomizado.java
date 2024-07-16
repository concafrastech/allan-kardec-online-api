package com.allankardeconline.globalkardec.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import com.allankardeconline.globalkardec.model.Matricula;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class MatriculaRepositoryCustomizado {

	@PersistenceContext
	private EntityManager em;

	public Page<Matricula> pesquisar(UUID uuidCentroEspirita, UUID uuidCalendario,
			UUID uuidCurso, String aluno, Long idVinculo, Pageable paginacao) {

		String conector = " WHERE ";
		StringBuilder sql = new StringBuilder("SELECT o From Matricula o ");

		if (!ObjectUtils.isEmpty(uuidCentroEspirita)) {
			sql.append(conector);
			sql.append(
					" o.turma.calendario.centroEspirita.uuid = :uuidCentroEspirita ");
			conector = " AND ";
		}

		if (!ObjectUtils.isEmpty(uuidCalendario)) {
			sql.append(conector);
			sql.append(" o.turma.calendario.uuid = :uuidCalendario ");
			conector = " AND ";
		}

		if (!ObjectUtils.isEmpty(uuidCurso)) {
			sql.append(conector);
			sql.append(" o.turma.curso.uuid = :uuidCurso ");
			conector = " AND ";
		}

		if (!ObjectUtils.isEmpty(aluno)) {
			sql.append(conector);
			sql.append(" lower(o.pessoa.nome) like lower(concat('%', :aluno,'%' )) ");
			conector = " AND ";
		}

		if (!ObjectUtils.isEmpty(idVinculo)) {
			sql.append(conector);
			sql.append(" o.vinculoMatricula.id = :idVinculo ");
			conector = " AND ";
		}
		
		TypedQuery<Matricula> typed = em.createQuery(sql.toString(), Matricula.class);
		typed.setFirstResult((int) paginacao.getOffset());
		typed.setMaxResults(paginacao.getPageSize());

		if (!ObjectUtils.isEmpty(uuidCentroEspirita)) {
			typed.setParameter("uuidCentroEspirita", uuidCentroEspirita);
		}
		if (!ObjectUtils.isEmpty(uuidCalendario)) {
			typed.setParameter("uuidCalendario", uuidCalendario);
		}
		if (!ObjectUtils.isEmpty(uuidCurso)) {
			typed.setParameter("uuidCurso", uuidCurso);
		}

		if (!ObjectUtils.isEmpty(aluno)) {
			typed.setParameter("aluno", aluno.toLowerCase());
		}

		if (!ObjectUtils.isEmpty(idVinculo)) {
			typed.setParameter("idVinculo", idVinculo);
		}

		List<Matricula> matriculas = typed.getResultList();

		long total = matriculas.size();
		return new PageImpl<Matricula>(matriculas, paginacao, total);

	}

}
