package com.allankardeconline.globalkardec.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allankardeconline.globalkardec.dto.CalendarioCompletoDTO;
import com.allankardeconline.globalkardec.dto.CalendarioDTO;
import com.allankardeconline.globalkardec.dto.DiaAulaDTO;
import com.allankardeconline.globalkardec.excecoes.DuplicidadeException;
import com.allankardeconline.globalkardec.excecoes.ParametroInvalidoException;
import com.allankardeconline.globalkardec.excecoes.RecursoNaoEncontradoException;
import com.allankardeconline.globalkardec.mapper.DozerMapper;
import com.allankardeconline.globalkardec.model.Calendario;
import com.allankardeconline.globalkardec.model.DiaAulaCalendario;
import com.allankardeconline.globalkardec.model.Metadados;
import com.allankardeconline.globalkardec.repository.CalendarioRepository;
import com.allankardeconline.globalkardec.repository.CentroEspiritaRepository;
import com.allankardeconline.globalkardec.repository.DiaAulaCalendarioRepository;
import com.allankardeconline.globalkardec.repository.TipoDiaCalendarioRepository;

import jakarta.transaction.Transactional;

@Service
public class CalendarioService {

	private Logger log = Logger.getLogger(CalendarioService.class.getName());

	@Autowired
	CalendarioRepository repository;

	@Autowired
	DiaAulaCalendarioRepository diaAulaCalendarioRepository;

	@Autowired
	CentroEspiritaRepository centroEspiritaRepository;

	@Autowired
	TipoDiaCalendarioRepository tipoDiaCalendarioRepository;

	public List<CalendarioDTO> obterTodosPorCentro(UUID uuidCentro) {
		return DozerMapper.parseListObjects(
				repository.obterTodosPorCentro(uuidCentro),
				CalendarioDTO.class);
	}
	
	public List<CalendarioDTO> obterTodos() {
		return DozerMapper.parseListObjects(
				repository.findAll(),
				CalendarioDTO.class);
	}

	public List<DiaAulaDTO> obterDiasAulaPorCalendario(UUID uuidCalendario) {
		return DozerMapper.parseListObjects(diaAulaCalendarioRepository
				.obterDiasAulaPorCalendario(uuidCalendario), DiaAulaDTO.class);
	}

	public CalendarioCompletoDTO obterPorUuid(UUID id) {

		var entity = repository.findByUuid(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Objeto não encontrado para o id "));

		return DozerMapper.parseObject(entity, CalendarioCompletoDTO.class);

	}

	public DiaAulaDTO obterDiaCalendarioPorUuid(UUID id) {

		var entity = diaAulaCalendarioRepository.findByUuid(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"DiaAulaCalendario não encontrado para o id "));

		return DozerMapper.parseObject(entity, DiaAulaDTO.class);

	}

//	public CalendarioDTO inserir(CalendarioDTO calendario, UUID uuidCentro) {
//
//		var entity = DozerMapper.parseObject(calendario, Calendario.class);
//
//		var duplicidade = repository.existePorCentroAndSemestreAndAno(
//				uuidCentro, calendario.getSemestre(), calendario.getAno());
//
//		if (duplicidade == true)
//			throw new DuplicidadeException(
//					"Calendário já cadastrado para o mesmo centro, semestre e ano.");
//
//		var centroEspirita = centroEspiritaRepository.findByUuid(uuidCentro)
//				.orElseThrow(() -> new RecursoNaoEncontradoException(
//						"Centro Espírita não encontrado para o uuid "
//								+ uuidCentro));
//
//		entity.setUuid(UUID.randomUUID());
//		entity.setCriacao(new Metadados());
//		entity.setCentroEspirita(centroEspirita);
//
//		var vo = DozerMapper.parseObject(repository.save(entity),
//				CalendarioDTO.class);
//
//		return vo;
//
//	}

	@Transactional
	public CalendarioCompletoDTO inserir(CalendarioCompletoDTO calendarioDTO) {

		var entity = DozerMapper.parseObject(calendarioDTO, Calendario.class);

		var duplicidade = repository.existePorCentroAndSemestreAndAno(
				calendarioDTO.getUuidCentro(), calendarioDTO.getSemestre(),
				calendarioDTO.getAno());

		if (duplicidade == true)
			throw new DuplicidadeException(
					"Calendário já cadastrado para o mesmo centro, semestre e ano.");

		var centroEspirita = centroEspiritaRepository
				.findByUuid(calendarioDTO.getUuidCentro())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Centro Espírita não encontrado para o uuid "
								+ calendarioDTO.getUuidCentro()));

		if (calendarioDTO.getAno() < 2024)
			throw new ParametroInvalidoException(
					"O ano informado é inválido " + calendarioDTO.getAno());

		if (calendarioDTO.getSemestre() != 1
				&& calendarioDTO.getSemestre() != 2)
			throw new ParametroInvalidoException(
					"O semestre deve ser 1 ou 2. Valor informado: "
							+ calendarioDTO.getSemestre());

		entity.setUuid(UUID.randomUUID());
		entity.setCriacao(new Metadados());
		entity.setCentroEspirita(centroEspirita);
		entity.setDiasAula(null);

		var calendario = DozerMapper.parseObject(repository.save(entity),
				CalendarioCompletoDTO.class);

		List<DiaAulaDTO> diasCalendarioDTOCadastrados = new ArrayList<>();

		calendarioDTO.getDiasAula().forEach(diaCalendarioDTO -> {

			var entidadeDiaCalendario = new DiaAulaCalendario();

			var tipoDiaCalendario = tipoDiaCalendarioRepository
					.findById(diaCalendarioDTO.getIdTipoDiaCalendario())
					.orElseThrow(() -> new RecursoNaoEncontradoException(
							"TipoDiaCalendario não encontrado para o id "
									+ diaCalendarioDTO
											.getIdTipoDiaCalendario()));

			entidadeDiaCalendario.setUuid(UUID.randomUUID());
			entidadeDiaCalendario.setDataAula(diaCalendarioDTO.getDataAula());
			entidadeDiaCalendario.setCalendario(entity);
			entidadeDiaCalendario.setTipoDiaCalendario(tipoDiaCalendario);
			entidadeDiaCalendario
					.setAulaEspecial(diaCalendarioDTO.getAulaEspecial());

			var dto = DozerMapper.parseObject(
					diaAulaCalendarioRepository.save(entidadeDiaCalendario),
					DiaAulaDTO.class);

			diasCalendarioDTOCadastrados.add(dto);

		});

		calendario.setDiasAula(diasCalendarioDTOCadastrados);
		return calendario;

	}

	@Transactional
	public CalendarioCompletoDTO alterar(CalendarioCompletoDTO calendarioDTO) {

		var entity = repository.findByUuid(calendarioDTO.getUuid())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Calendario não encontrado para o uuid "
								+ calendarioDTO.getUuid()));

		if (calendarioDTO.getSemestre() != 1
				&& calendarioDTO.getSemestre() != 2)
			throw new ParametroInvalidoException(
					"O semestre deve ser 1 ou 2. Valor informado: "
							+ calendarioDTO.getSemestre());

		entity.setAno(calendarioDTO.getAno());
		entity.setSemestre(calendarioDTO.getSemestre());
		entity.setDiasAula(null);

		var calendario = DozerMapper.parseObject(repository.save(entity),
				CalendarioCompletoDTO.class);

		List<DiaAulaDTO> diasCalendarioDTOCadastrados = new ArrayList<>();

		calendarioDTO.getDiasAula().forEach(diaCalendarioDTO -> {

			DiaAulaCalendario entidadeDiaCalendario = null;
			if (!Objects.isNull(diaCalendarioDTO.getUuid())) {
				entidadeDiaCalendario = diaAulaCalendarioRepository
						.findByUuid(diaCalendarioDTO.getUuid())
						.orElseThrow(() -> new RecursoNaoEncontradoException(
								"DiaAulaCalendario não encontrado para o uuid "
										+ diaCalendarioDTO.getUuid()));

				if (!entidadeDiaCalendario.getCalendario().getUuid()
						.equals(calendarioDTO.getUuid()))
					throw new ParametroInvalidoException(
							"O ID do dia da Aula é incompatível com o Calendário "
									+ calendario.getUuid());

			} else {
				// É novo
				entidadeDiaCalendario = DozerMapper
						.parseObject(diaCalendarioDTO, DiaAulaCalendario.class);
				entidadeDiaCalendario.setUuid(UUID.randomUUID());
				entidadeDiaCalendario.setCalendario(entity);
			}

			var tipoDiaCalendario = tipoDiaCalendarioRepository
					.findById(diaCalendarioDTO.getIdTipoDiaCalendario())
					.orElseThrow(() -> new RecursoNaoEncontradoException(
							"TipoDiaCalendario não encontrado para o id "
									+ diaCalendarioDTO
											.getIdTipoDiaCalendario()));

			entidadeDiaCalendario.setDataAula(diaCalendarioDTO.getDataAula());
			entidadeDiaCalendario.setTipoDiaCalendario(tipoDiaCalendario);
			entidadeDiaCalendario
					.setAulaEspecial(diaCalendarioDTO.getAulaEspecial());

			diasCalendarioDTOCadastrados.add(DozerMapper.parseObject(
					diaAulaCalendarioRepository.save(entidadeDiaCalendario),
					DiaAulaDTO.class));

		});

		calendarioDTO.setDiasAula(diasCalendarioDTOCadastrados);
		return calendarioDTO;

	}

	public void excluir(UUID id) {
		Calendario entidade = repository.findByUuid(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Objeto não encontrado para o id " + id));

		repository.delete(entidade);
	}
	
	
	public void excluirDiaCalendario(UUID uuid) {
		DiaAulaCalendario entidade = diaAulaCalendarioRepository.findByUuid(uuid)
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Objeto não encontrado para o uuid " + uuid));

		diaAulaCalendarioRepository.delete(entidade);
	}

}
