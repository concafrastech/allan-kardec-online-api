package com.allankardeconline.globalkardec.services;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allankardeconline.globalkardec.dto.ConteudoDTO;
import com.allankardeconline.globalkardec.excecoes.RecursoNaoEncontradoException;
import com.allankardeconline.globalkardec.mapper.DozerMapper;
import com.allankardeconline.globalkardec.model.Conteudo;
import com.allankardeconline.globalkardec.repository.ConteudoRepository;
import com.allankardeconline.globalkardec.repository.CursoRepository;

import jakarta.transaction.Transactional;

@Service
public class ConteudoService {

	private Logger log = Logger.getLogger(ConteudoService.class.getName());

	@Autowired
	ConteudoRepository repository;

	@Autowired
	CursoRepository cursoRepository;

	public List<ConteudoDTO> obterTodosPorCurso(UUID cursoUuid) {
		return DozerMapper.parseListObjects(
				repository.getAllByCursoUuid(cursoUuid), ConteudoDTO.class);
	}

	public ConteudoDTO obterPorUuid(UUID id) {

		var entity = repository.findByUuid(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Conteudo não encontrado para o uuid " + id));

		return DozerMapper.parseObject(entity, ConteudoDTO.class);

	}

	public ConteudoDTO inserir(ConteudoDTO conteudo) {

		var curso = cursoRepository.findByUuid(conteudo.getCurso())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Curso não encontrado para o uuid "
								+ conteudo.getCurso()));

		var entity = DozerMapper.parseObject(conteudo, Conteudo.class);

		entity.setUuid(UUID.randomUUID());
		entity.setCurso(curso);

		var dto = DozerMapper.parseObject(repository.save(entity),
				ConteudoDTO.class);

		return dto;

	}

	@Transactional
	public void inserirLote(List<ConteudoDTO> conteudos) {

		conteudos.forEach(conteudo -> {

			var curso = cursoRepository.findByUuid(conteudo.getCurso())
					.orElseThrow(() -> new RecursoNaoEncontradoException(
							"Curso não encontrado para o uuid "
									+ conteudo.getCurso()));

			var entity = DozerMapper.parseObject(conteudo, Conteudo.class);

			entity.setUuid(UUID.randomUUID());
			entity.setCurso(curso);

			repository.save(entity);

		});

	}

	public ConteudoDTO alterar(ConteudoDTO conteudoDTO) {

		Conteudo entity = repository.findByUuid(conteudoDTO.getUuid())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Conteudo não encontrado para o id "
								+ conteudoDTO.getUuid()));

		var curso = cursoRepository.findByUuid(conteudoDTO.getCurso())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Curso não encontrado para o uuid "
								+ conteudoDTO.getCurso()));

		entity.setNome(conteudoDTO.getNome());
		entity.setCurso(curso);
		entity.setOrdem(conteudoDTO.getOrdem());

		var dto = DozerMapper.parseObject(repository.save(entity),
				ConteudoDTO.class);

		return dto;

	}

	public void excluir(UUID id) {
		Conteudo entity = repository.findByUuid(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Conteudo não encontrado para o id " + id));

		repository.delete(entity);
	}

}
