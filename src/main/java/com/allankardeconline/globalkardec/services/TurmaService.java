package com.allankardeconline.globalkardec.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.allankardeconline.globalkardec.dto.LoteTurmaDTO;
import com.allankardeconline.globalkardec.dto.TurmaDTO;
import com.allankardeconline.globalkardec.excecoes.InformacaoObrigatoriaException;
import com.allankardeconline.globalkardec.excecoes.OperacaoNaoAutorizadaException;
import com.allankardeconline.globalkardec.excecoes.RecursoNaoEncontradoException;
import com.allankardeconline.globalkardec.mapper.DozerMapper;
import com.allankardeconline.globalkardec.model.Matricula;
import com.allankardeconline.globalkardec.model.Metadados;
import com.allankardeconline.globalkardec.model.Turma;
import com.allankardeconline.globalkardec.model.categoricos.SituacaoMatricula;
import com.allankardeconline.globalkardec.model.visao.FrequenciaAlunoTurmaEncerramentoVisao;
import com.allankardeconline.globalkardec.repository.CalendarioRepository;
import com.allankardeconline.globalkardec.repository.CentroEspiritaRepository;
import com.allankardeconline.globalkardec.repository.ConfiguracaoGlobalKardecRepository;
import com.allankardeconline.globalkardec.repository.CursoRepository;
import com.allankardeconline.globalkardec.repository.FrequenciaAlunoRepository;
import com.allankardeconline.globalkardec.repository.FrequenciaAlunoTurmaEncerramentoRepository;
import com.allankardeconline.globalkardec.repository.MatriculaRepository;
import com.allankardeconline.globalkardec.repository.TurmaRepository;

import jakarta.transaction.Transactional;

@Service
public class TurmaService {

	private Logger log = Logger.getLogger(TurmaService.class.getName());

	@Autowired
	TurmaRepository repository;

	@Autowired
	CursoRepository cursoRepository;

	@Autowired
	CentroEspiritaRepository centroEspiritaRepository;

	@Autowired
	CalendarioRepository calendarioRepository;

	@Autowired
	MatriculaRepository matriculaRepository;

	@Autowired
	FrequenciaAlunoRepository frequenciaAlunoRepository;

	@Autowired
	FrequenciaAlunoTurmaEncerramentoRepository frequnciaAlunoTurmaEncerramentoRepository;

	@Autowired
	ConfiguracaoGlobalKardecRepository configuracaoGlobalKardecRepository;


	public Page<TurmaDTO> obterTodosPorCentro(UUID uuidCentro,
			Pageable paginacao) {
		var page = repository.obterTodosPorCentro(uuidCentro, paginacao);

		var pagesDTO = page
				.map(objeto -> DozerMapper.parseObject(objeto, TurmaDTO.class));
		return pagesDTO;

	}

	public Page<TurmaDTO> obterPorCentroENomeCurso(UUID uuidCentro,
			String nomeCurso, Pageable paginacao) {

		var page = repository.obterPorCentroENomeCurso(uuidCentro,
				nomeCurso.toLowerCase(), paginacao);

		var pagesDTO = page
				.map(objeto -> DozerMapper.parseObject(objeto, TurmaDTO.class));
		return pagesDTO;

	}
	
	
	public List<TurmaDTO> obterPorCalendario(UUID uuidCalendario) {

		return DozerMapper.parseListObjects(
				repository.obterPorCalendario(uuidCalendario),
				TurmaDTO.class);


	}

	public TurmaDTO obterPorUuid(UUID id) {

		var entity = repository.findByUuid(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Objeto não encontrado para o id " + id));

		return DozerMapper.parseObject(entity, TurmaDTO.class);

	}

	public TurmaDTO obterTurmaNocoesBasicasAtiva() {

		var entity = configuracaoGlobalKardecRepository
				.findFirstByOrderByIdAsc();

		if (entity == null)
			throw new RecursoNaoEncontradoException(
					"Não foi encontrado nenhuma turma inicial. "
							+ "Por favor, entrar em contato com o administrador do sistema.");

		return DozerMapper.parseObject(entity.getTurmaMatriculaInicial(), TurmaDTO.class);

	}

	public TurmaDTO inserir(TurmaDTO turma) {

		var entity = DozerMapper.parseObject(turma, Turma.class);

		var curso = cursoRepository.findByUuid(turma.getCurso())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Curso não encontrado para o uuid "
								+ turma.getCurso()));

		var calendario = calendarioRepository.findByUuid(turma.getCalendario())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Calendário não encontrado para o uuid "
								+ turma.getCalendario()));

		entity.setUuid(UUID.randomUUID());
		entity.setCriacao(new Metadados());
		entity.setCurso(curso);
		entity.setCalendario(calendario);

		var dto = DozerMapper.parseObject(repository.save(entity),
				TurmaDTO.class);

		return dto;

	}

	@Transactional
	public List<TurmaDTO> inserirTurmaEmLote(LoteTurmaDTO lote) {

		var calendario = calendarioRepository
				.findByUuid(lote.getUuidCalendario())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Calendário não encontrado para o uuid "
								+ lote.getUuidCalendario()));

		List<Turma> turmasCriadas = new ArrayList<>();

		lote.getTurmas().forEach(turma -> {

			var turmaAnterior = repository.findByUuid(turma)
					.orElseThrow(() -> new RecursoNaoEncontradoException(
							"Turma não encontrada para o uuid " + turma));

			Turma entity = new Turma();
			entity.setUuid(UUID.randomUUID());
			entity.setCriacao(new Metadados());
			entity.setCurso(turmaAnterior.getCurso());
			entity.setCalendario(calendario);
			entity.setLinkSala(turmaAnterior.getLinkSala());

			turmasCriadas.add(repository.save(entity));

		});

		var dto = DozerMapper.parseListObjects(turmasCriadas, TurmaDTO.class);

		return dto;
	}

	public TurmaDTO alterar(TurmaDTO turma) {

		Turma entity = repository.findByUuid(turma.getUuid())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Objeto não encontrado para o uuid "
								+ turma.getUuid()));

		// Verifica se nao houe alteracao do calendario referente a CE diferente
		var novoCalendario = calendarioRepository
				.findByUuid(turma.getCalendario())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Calendário não encontrado para o uuid "
								+ turma.getCalendario()));

//		System.out.println("CE entity id: "
//				+ entity.getCalendario().getCentroEspirita().getId());
//		System.out.println("CE calendario original id: "
//				+ novoCalendario.getCentroEspirita().getId());

		if (!(entity.getCalendario().getCentroEspirita()
				.equals(novoCalendario.getCentroEspirita()))) {
			throw new OperacaoNaoAutorizadaException(
					"Alteração não autorizada.");
		}

		var curso = cursoRepository.findByUuid(turma.getCurso())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Curso não encontrado para o uuid "
								+ turma.getCurso()));

		var calendario = calendarioRepository.findByUuid(turma.getCalendario())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Calendário não encontrado para o uuid "
								+ turma.getCalendario()));

		entity.setCurso(curso);
		entity.setCalendario(calendario);
		entity.setLinkSala(turma.getLinkSala());

		var dto = DozerMapper.parseObject(repository.save(entity),
				TurmaDTO.class);

		return dto;

	}

	public void excluir(UUID id) {
		Turma entidade = repository.findByUuid(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Objeto não encontrado para o id " + id));

		repository.delete(entidade);
	}

	@Transactional
	public void encerrarTurma(UUID uuid) {

		Turma turma = repository.findByUuid(uuid)
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Turma não encontrada para o uuid " + uuid));

		// Verifica se todas os dias do calendário estão com a frequencia
		// registrada para ao menos um aluno;
		List<FrequenciaAlunoTurmaEncerramentoVisao> frequencias = frequnciaAlunoTurmaEncerramentoRepository
				.obterFrequenciaAlunoTurmaEncerramento(uuid);

		boolean encontrouUmAlunoComTodasFrequenciasAnotadas = false;

		for (FrequenciaAlunoTurmaEncerramentoVisao frequencia : frequencias) {

			if (frequencia.getDiasAula()
					.equals(frequencia.getDiasFrequenciaRegistrada())) {
				encontrouUmAlunoComTodasFrequenciasAnotadas = true;
				break;
			}

		}

		if (!encontrouUmAlunoComTodasFrequenciasAnotadas)
			throw new InformacaoObrigatoriaException(
					"Para o encerramento da turma é necessário que todos os "
							+ "dias do calendário estejam com a frequência registrada.");

		// Procedimentos par encerramento da turma:
		// Aferir quem obteve mais de 0.75 (aprovado e reprovado)
		// Definir a data de encerramento

		List<Matricula> matriculas = matriculaRepository
				.obterMatriculasPorTurma(uuid);

		matriculas.forEach(matricula -> {

			FrequenciaAlunoTurmaEncerramentoVisao frequencia = frequnciaAlunoTurmaEncerramentoRepository
					.obterFrequenciaAlunoTurmaEncerramento(uuid,
							matricula.getUuid());

			Float taxaDePresencas = (float) frequencia.getDiasPresentes()
					/ frequencia.getDiasAula();

			if (taxaDePresencas.floatValue() >= 0.75) {
				matricula.setSituacaoMatricula(SituacaoMatricula.APROVADO);
			} else {
				matricula.setSituacaoMatricula(SituacaoMatricula.REPROVADO);
			}
			matricula.setDataEncerramento(LocalDate.now());

			matriculaRepository.save(matricula);

		});

		turma.setDataEncerramento(new Date());
		repository.save(turma);
	}

	@Transactional
	public void reabrirTurma(UUID uuid) {

		Turma turma = repository.findByUuid(uuid)
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Turma não encontrada para o uuid " + uuid));

		// Procedimentos par encerramento da turma:
		// Aferir quem obteve mais de 0.75 (aprovado e reprovado)
		// Definir a data de encerramento

		List<Matricula> matriculas = matriculaRepository
				.obterMatriculasPorTurma(uuid);

		matriculas.forEach(matricula -> {

			matricula.setSituacaoMatricula(SituacaoMatricula.MATRICULADO);
			matricula.setDataEncerramento(null);

		});

		turma.setDataEncerramento(new Date());
		repository.save(turma);
	}

}
