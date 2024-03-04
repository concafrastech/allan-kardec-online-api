package com.allankardeconline.globalkardec.services;

import java.util.Date;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allankardeconline.globalkardec.dto.ConfiguracaoGlobalKardecDTO;
import com.allankardeconline.globalkardec.excecoes.RecursoNaoEncontradoException;
import com.allankardeconline.globalkardec.mapper.DozerMapper;
import com.allankardeconline.globalkardec.model.ConfiguracaoGlobalKardec;
import com.allankardeconline.globalkardec.model.Metadados;
import com.allankardeconline.globalkardec.model.Turma;
import com.allankardeconline.globalkardec.repository.ConfiguracaoGlobalKardecRepository;
import com.allankardeconline.globalkardec.repository.TurmaRepository;

@Service
public class ConfiguracaoGlobalKardecService {

	private Logger log = Logger
			.getLogger(ConfiguracaoGlobalKardecService.class.getName());

	@Autowired
	ConfiguracaoGlobalKardecRepository repository;

	@Autowired
	TurmaRepository turmaRepository;

	public ConfiguracaoGlobalKardecDTO alterar(
			ConfiguracaoGlobalKardecDTO dto) {

		Turma turma = turmaRepository.findByUuid(dto.getTurmaMatriculaInicial())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Turma não encontrada para o uuid "
								+ dto.getTurmaMatriculaInicial()));

		ConfiguracaoGlobalKardec entity = repository.findFirstByOrderByIdAsc();

		if (entity == null) {
			entity = new ConfiguracaoGlobalKardec();
			entity.setAlteracao(new Metadados());
		} else {
			entity.getAlteracao().setDataOperacao(new Date());
		}

		entity.setTurmaMatriculaInicial(turma);

		var vo = DozerMapper.parseObject(repository.save(entity),
				ConfiguracaoGlobalKardecDTO.class);

		return vo;

	}

}
