package com.allankardeconline.globalkardec.services;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allankardeconline.globalkardec.dto.CentroEspiritaDTO;
import com.allankardeconline.globalkardec.excecoes.RecursoNaoEncontradoException;
import com.allankardeconline.globalkardec.mapper.DozerMapper;
import com.allankardeconline.globalkardec.repository.CentroEspiritaRepository;

@Service
public class CentroEspiritaService {

	private Logger log = Logger
			.getLogger(CentroEspiritaService.class.getName());

	@Autowired
	CentroEspiritaRepository repository;

	public List<CentroEspiritaDTO> obterTodos() {
		return DozerMapper.parseListObjects(repository.findAll(),
				CentroEspiritaDTO.class);
	}

	public List<CentroEspiritaDTO> obterPorNome(String nome) {
		return DozerMapper.parseListObjects(
				repository.findByNomeLikeIgnoreCaseOrderByNome(nome),
				CentroEspiritaDTO.class);
	}

	public CentroEspiritaDTO obterPorUuid(UUID id) {
		log.info("Finding one centro espírita");

		var entity = repository.findByUuid(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Objeto não encontrado para o id "));

		return DozerMapper.parseObject(entity, CentroEspiritaDTO.class);

	}

}
