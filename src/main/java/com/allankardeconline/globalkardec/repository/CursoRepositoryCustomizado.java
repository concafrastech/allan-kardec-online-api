package com.allankardeconline.globalkardec.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import com.allankardeconline.globalkardec.model.Curso;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class CursoRepositoryCustomizado {

	@PersistenceContext
	private EntityManager em;

	public Page<Curso> pesquisar(String curso, String idioma, String instituto,
			Pageable paginacao) {

		String conector = " WHERE ";
		StringBuilder sql = new StringBuilder("SELECT o From Curso o ");

		if (!ObjectUtils.isEmpty(curso)) {
			sql.append(conector);
			sql.append(" lower(o.nome) like lower( :curso ) ");
			conector = " AND ";
		}

		if (!ObjectUtils.isEmpty(idioma)) {
			sql.append(conector);
			sql.append(" lower(o.idioma.nome) like lower( :idioma ) ");
			conector = " AND ";
		}

		if (!ObjectUtils.isEmpty(instituto)) {
			sql.append(conector);
			sql.append(" lower(o.instituto.nome) like lower( :instituto ) ");
			conector = " AND ";

		}

		TypedQuery<Curso> typed = em.createQuery(sql.toString(), Curso.class);
		typed.setFirstResult((int) paginacao.getOffset());
		typed.setMaxResults(paginacao.getPageSize());

		if (!ObjectUtils.isEmpty(curso)) {
			typed.setParameter("curso", "%" + curso + "%");
		}

		if (!ObjectUtils.isEmpty(idioma)) {
			typed.setParameter("idioma", "%" + idioma + "%");
		}

		if (!ObjectUtils.isEmpty(instituto)) {
			typed.setParameter("instituto", "%" + instituto + "%");
		}

		List<Curso> cursos = typed.getResultList();

		long total = cursos.size();
		return new PageImpl<Curso>(cursos, paginacao, total);

	}

}
