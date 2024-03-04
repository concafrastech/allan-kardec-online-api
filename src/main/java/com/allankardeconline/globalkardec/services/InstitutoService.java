package com.allankardeconline.globalkardec.services;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import com.allankardeconline.globalkardec.dto.InstitutoDTO;
import com.allankardeconline.globalkardec.excecoes.RecursoNaoEncontradoException;
import com.allankardeconline.globalkardec.mapper.DozerMapper;
import com.allankardeconline.globalkardec.model.Instituto;
import com.allankardeconline.globalkardec.repository.ConteudoRepository;
import com.allankardeconline.globalkardec.repository.InstitutoRepository;

@Service
public class InstitutoService {

	private Logger log = Logger.getLogger(InstitutoService.class.getName());

	@Autowired
	InstitutoRepository repository;

	@Autowired
	ConteudoRepository categoriaRepository;

	

	public List<InstitutoDTO> obterTodos() {
		return DozerMapper.parseListObjects(repository.findAll(),
				InstitutoDTO.class);
	}

	public List<InstitutoDTO> obterPorNome(String nome) {
		return DozerMapper.parseListObjects(
				repository.findByNomeLikeIgnoreCaseOrderByNome(nome), InstitutoDTO.class);
	}

	public InstitutoDTO obterPorUuid(UUID id) {
		log.info("Finding one instituto");

		var entity = repository.findByUuid(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Objeto não encontrado para o id "));

		return DozerMapper.parseObject(entity, InstitutoDTO.class);

	}

	public InstitutoDTO inserir(InstitutoDTO instituto) {

		var entity = DozerMapper.parseObject(instituto, Instituto.class);

		var vo = DozerMapper.parseObject(repository.save(entity),
				InstitutoDTO.class);

		return vo;

	}

	public InstitutoDTO alterar(InstitutoDTO instituto) {

		Instituto entidade = repository.findByUuid(instituto.getUuid())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Objeto não encontrado para o uuid "
								+ instituto.getUuid()));

//		CategoriaMaterial categoria = categoriaRepository.findById(produto.getIdCategoria())
//				.orElseThrow(() -> new RecursoNaoEncontradoException("Objeto categoria não encontrado para o id "));

		entidade.setNome(instituto.getNome());

		var vo = DozerMapper.parseObject(repository.save(entidade),
				InstitutoDTO.class);

		return vo;

	}

	public void excluir(UUID id) {
		Instituto entidade = repository.findByUuid(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Objeto não encontrado para o id " + id));

		repository.delete(entidade);
	}

}
