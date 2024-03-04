package com.allankardeconline.globalkardec.services;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import com.allankardeconline.globalkardec.dto.ItemConteudoDTO;
import com.allankardeconline.globalkardec.excecoes.RecursoNaoEncontradoException;
import com.allankardeconline.globalkardec.mapper.DozerMapper;
import com.allankardeconline.globalkardec.model.ItemConteudo;
import com.allankardeconline.globalkardec.model.Metadados;
import com.allankardeconline.globalkardec.repository.CentroEspiritaRepository;
import com.allankardeconline.globalkardec.repository.ConteudoRepository;
import com.allankardeconline.globalkardec.repository.ItemConteudoRepository;
import com.allankardeconline.globalkardec.repository.TipoRecursoAulaRepository;
import com.allankardeconline.site.model.CentroEspirita;

@Service
public class ItemConteudoService {

	private Logger log = Logger.getLogger(ItemConteudoService.class.getName());

	@Autowired
	ItemConteudoRepository repository;

	@Autowired
	ConteudoRepository categoriaRepository;

	@Autowired
	CentroEspiritaRepository centroEspiritaRepository;

	@Autowired
	TipoRecursoAulaRepository tipoRecursoAulaRepository;

	public List<ItemConteudoDTO> pesquisarPorExemplo(ItemConteudoDTO filtro) {
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase()
				.withStringMatcher(StringMatcher.CONTAINING);

		var entidade = DozerMapper.parseObject(filtro, ItemConteudo.class);

		Example<ItemConteudo> exemplo = Example.of(entidade, matcher);
		return DozerMapper.parseListObjects(repository.findAll(exemplo),
				ItemConteudoDTO.class);

	}

	public List<ItemConteudoDTO> obterTodosItensGlobaisEConteudoUuid(
			UUID uuidCentro, UUID uuidConteudo) {
		var resultado = repository
				.obterTodosItensGlobaisEConteudoUuid(uuidCentro, uuidConteudo);
		return DozerMapper.parseListObjects(resultado, ItemConteudoDTO.class);
	}

	public List<ItemConteudoDTO> obterPorNome(String nome) {
		return DozerMapper.parseListObjects(
				repository.findByNomeLikeIgnoreCase(nome),
				ItemConteudoDTO.class);
	}

	public ItemConteudoDTO obterPorUuid(UUID id) {

		var entity = repository.findByUuid(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Objeto não encontrado para o id " + id));

		return DozerMapper.parseObject(entity, ItemConteudoDTO.class);

	}

	public ItemConteudoDTO inserir(ItemConteudoDTO item, UUID uuidCentro) {

		var entity = DozerMapper.parseObject(item, ItemConteudo.class);

		var conteudo = categoriaRepository.findByUuid(item.getConteudo())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Categoria de item não encontrado para o uuid "
								+ item.getConteudo()));

		var centroEspirita = centroEspiritaRepository.findByUuid(uuidCentro)
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Centro espirita não encontrado para o uuid "
								+ uuidCentro));

		var tipoRecurso = tipoRecursoAulaRepository
				.findById(item.getIdTipoRecursoAula())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"TipoRecursoAula de item não encontrado para o uuid "
								+ item.getIdTipoRecursoAula()));

		entity.setUuid(UUID.randomUUID());
		entity.setConteudo(conteudo);
		entity.setCriacao(new Metadados());
		entity.setTipoRecursoAula(tipoRecurso);
		entity.setCentroEspirita(centroEspirita);
		entity.setVisivel(true);

		var dto = DozerMapper.parseObject(repository.save(entity),
				ItemConteudoDTO.class);

		return dto;

	}

	public ItemConteudoDTO alterar(ItemConteudoDTO item) {

		ItemConteudo entity = repository.findByUuid(item.getUuid())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Objeto não encontrado para o uuid " + item.getUuid()));

//		if(entity.getCentroEspirita().getUuid().equals(item.getuu))

		var conteudo = categoriaRepository.findByUuid(item.getConteudo())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Categoria de item não encontrado para o uuid "
								+ item.getConteudo()));

		var tipoRecurso = tipoRecursoAulaRepository
				.findById(item.getIdTipoRecursoAula())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"TipoRecursoAula de item não encontrado para o uuid "
								+ item.getIdTipoRecursoAula()));

		entity.setNome(item.getNome());
		entity.setDescricao(item.getDescricao());
		entity.setLinkRecurso(item.getLinkRecurso());
		entity.setTipoRecursoAula(tipoRecurso);
		entity.setConteudo(conteudo);
		entity.setOrdem(item.getOrdem());

		var vo = DozerMapper.parseObject(repository.save(entity),
				ItemConteudoDTO.class);

		return vo;

	}

	public void excluir(UUID id) {
		ItemConteudo entidade = repository.findByUuid(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Objeto não encontrado para o id " + id));

		repository.delete(entidade);
	}

}
