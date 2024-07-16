package com.allankardeconline.globalkardec.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allankardeconline.config.ConfiguracaoGeralGlobalKardec;
import com.allankardeconline.globalkardec.dto.FrequenciaAlunoConsultaDTO;
import com.allankardeconline.globalkardec.dto.FrequenciaAlunoIndividualDTO;
import com.allankardeconline.globalkardec.dto.FrequenciaAlunoTurmaEncerramentoDTO;
import com.allankardeconline.globalkardec.dto.ListaFrequenciaAlunoDTO;
import com.allankardeconline.globalkardec.dto.MatriculadosTurmaFrequenciaDiaDTO;
import com.allankardeconline.globalkardec.excecoes.ParametroInvalidoException;
import com.allankardeconline.globalkardec.excecoes.RecursoNaoEncontradoException;
import com.allankardeconline.globalkardec.mapper.DozerMapper;
import com.allankardeconline.globalkardec.model.DiaAulaCalendario;
import com.allankardeconline.globalkardec.model.FrequenciaAluno;
import com.allankardeconline.globalkardec.model.Matricula;
import com.allankardeconline.globalkardec.model.Metadados;
import com.allankardeconline.globalkardec.model.categoricos.SituacaoFrequencia;
import com.allankardeconline.globalkardec.model.visao.FrequenciaAlunoTurmaEncerramentoVisao;
import com.allankardeconline.globalkardec.model.visao.MatriculadosTurmaFrequenciaDiaVisao;
import com.allankardeconline.globalkardec.repository.DiaAulaCalendarioRepository;
import com.allankardeconline.globalkardec.repository.FrequenciaAlunoConsultaRepository;
import com.allankardeconline.globalkardec.repository.FrequenciaAlunoRepository;
import com.allankardeconline.globalkardec.repository.FrequenciaAlunoTurmaEncerramentoRepository;
import com.allankardeconline.globalkardec.repository.MatriculaRepository;
import com.allankardeconline.globalkardec.repository.MatriculasTurmaFrequenciaDiaRepository;
import com.allankardeconline.globalkardec.repository.SituacaoFrequenciaRepository;

import jakarta.transaction.Transactional;

@Service
public class FrequenciaService {

	private Logger log = Logger.getLogger(FrequenciaService.class.getName());

	@Autowired
	MatriculaRepository repository;

	@Autowired
	SituacaoFrequenciaRepository situacaoFrequenciaRepository;

	@Autowired
	FrequenciaAlunoRepository frequenciaAlunoRepository;

	@Autowired
	FrequenciaAlunoConsultaRepository frequenciaAlunoConsultaRepository;

	@Autowired
	DiaAulaCalendarioRepository diaAulaCalendarioRepository;

	@Autowired
	MatriculasTurmaFrequenciaDiaRepository matriculaTurmaFrequenciaDiaRepository;

	@Autowired
	FrequenciaAlunoTurmaEncerramentoRepository frequenciaAlunoTurmaEncerramentoRepository;

	@Autowired
	ConfiguracaoGeralGlobalKardec configuracao;

	public List<MatriculadosTurmaFrequenciaDiaDTO> obterFrequenciaMatriculadosPorCalendarioEData(
			UUID uuidCalendario, String dataAula) {
		LocalDate data = null;
		try {
			data = LocalDate.parse(dataAula,
					DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		} catch (Exception e) {
			throw new ParametroInvalidoException(
					"A data deve estar no formato aaaa-mm-dd: " + dataAula);
		}
		List<MatriculadosTurmaFrequenciaDiaVisao> frequencias = matriculaTurmaFrequenciaDiaRepository
				.obterMatriculadosPorCalendario(uuidCalendario, data);

		return DozerMapper.parseListObjects(frequencias,
				MatriculadosTurmaFrequenciaDiaDTO.class);

	}

	@Transactional
	public void registrarFrequencia(ListaFrequenciaAlunoDTO dto) {

		DiaAulaCalendario diaAula = diaAulaCalendarioRepository
				.findByUuid(dto.getDiaCalendario())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"DiaAulaCalendario não encontrado para o uuid "
								+ dto.getDiaCalendario()));

		dto.getFrequencias().forEach(frequenciaAluno -> {

			Matricula matricula = repository
					.findByUuid(frequenciaAluno.getMatricula())
					.orElseThrow(() -> new RecursoNaoEncontradoException(
							"Matricula não encontrada para o uuid "
									+ frequenciaAluno.getMatricula()));

			SituacaoFrequencia situacao = situacaoFrequenciaRepository
					.findById(frequenciaAluno.getSituacaoFrequencia())
					.orElseThrow(() -> new RecursoNaoEncontradoException(
							"SituacaoMatricula não encontrada para o uuid "
									+ frequenciaAluno.getSituacaoFrequencia()));

			FrequenciaAluno frequencia = null;

			// Verifica se já foi registrada frequencia desta matricula
			frequencia = frequenciaAlunoRepository
					.obterFrequenciaPorDiaEMatricula(dto.getDiaCalendario(),
							frequenciaAluno.getMatricula());

			if (frequencia != null) {

				frequencia.setSituacaoFrequencia(situacao);

			} else {

				frequencia = new FrequenciaAluno();
				frequencia.setDiaAulaCalendario(diaAula);
				frequencia.setMatricula(matricula);
				frequencia.setSituacaoFrequencia(situacao);
			}
			frequencia.setCriacao(new Metadados());

			frequenciaAlunoRepository.save(frequencia);

		});

	}

	@Transactional
	public void registrarFrequenciaPeloAluno(
			FrequenciaAlunoIndividualDTO frequenciaDTO) {

		DiaAulaCalendario diaAula = diaAulaCalendarioRepository
				.findByUuid(frequenciaDTO.getUuidDiaCalendario())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"DiaAulaCalendario não encontrado para o uuid "
								+ frequenciaDTO.getUuidDiaCalendario()));

		Matricula matricula = repository
				.findByUuid(frequenciaDTO.getUuidMatricula())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Matricula não encontrada para o uuid "
								+ frequenciaDTO.getUuidMatricula()));

		SituacaoFrequencia situacao = situacaoFrequenciaRepository
				.findById(configuracao.getIdSituacaoFrequenciaPresente())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"SituacaoMatricula não encontrada para o uuid "
								+ configuracao
										.getIdSituacaoFrequenciaPresente()));

		FrequenciaAluno frequencia = null;

		// Verifica se já foi registrada frequencia desta matricula
		frequencia = frequenciaAlunoRepository.obterFrequenciaPorDiaEMatricula(
				frequenciaDTO.getUuidDiaCalendario(),
				frequenciaDTO.getUuidMatricula());

		if (frequencia != null) {

			frequencia.setSituacaoFrequencia(situacao);

		} else {

			frequencia = new FrequenciaAluno();
			frequencia.setDiaAulaCalendario(diaAula);
			frequencia.setMatricula(matricula);
			frequencia.setSituacaoFrequencia(situacao);
		}
		frequencia.setCriacao(new Metadados());

		frequenciaAlunoRepository.save(frequencia);

	}

	public List<FrequenciaAlunoTurmaEncerramentoDTO> obterFrequenciaAlunoTurmaEncerramento(
			UUID uuidTurma) {

		List<FrequenciaAlunoTurmaEncerramentoVisao> frequencias = frequenciaAlunoTurmaEncerramentoRepository
				.obterFrequenciaAlunoTurmaEncerramento(uuidTurma);

		return DozerMapper.parseListObjects(frequencias,
				FrequenciaAlunoTurmaEncerramentoDTO.class);

	}

	public List<FrequenciaAlunoConsultaDTO> obterFrequenciaPorMatricula(
			UUID uuidMatricula) {
		return DozerMapper
				.parseListObjects(
						frequenciaAlunoRepository
								.obterFrequenciasPorAluno(uuidMatricula),
						FrequenciaAlunoConsultaDTO.class);

	}

	public List<FrequenciaAlunoConsultaDTO> obterFrequenciasPorTurmaEDia(
			UUID uuidTurma, UUID uuidDiaCalendario) {
		return DozerMapper.parseListObjects(
				frequenciaAlunoConsultaRepository.obterFrequenciasPorTurmaEDia(
						uuidTurma, uuidDiaCalendario),
				FrequenciaAlunoConsultaDTO.class);

	}

}
