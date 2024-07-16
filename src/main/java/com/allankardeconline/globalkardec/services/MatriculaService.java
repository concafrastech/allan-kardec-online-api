package com.allankardeconline.globalkardec.services;

import java.time.ZoneId;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.allankardeconline.config.ConfiguracaoGeralGlobalKardec;
import com.allankardeconline.globalkardec.dto.LoteMatriculaDTO;
import com.allankardeconline.globalkardec.dto.MatriculaCadastroDTO;
import com.allankardeconline.globalkardec.dto.MatriculaConsultaDTO;
import com.allankardeconline.globalkardec.dto.MatriculaDTO;
import com.allankardeconline.globalkardec.dto.MatriculaDesistenciaDTO;
import com.allankardeconline.globalkardec.excecoes.DuplicidadeException;
import com.allankardeconline.globalkardec.excecoes.RecursoNaoEncontradoException;
import com.allankardeconline.globalkardec.mapper.DozerMapper;
import com.allankardeconline.globalkardec.model.Matricula;
import com.allankardeconline.globalkardec.model.Pessoa;
import com.allankardeconline.globalkardec.model.Turma;
import com.allankardeconline.globalkardec.model.categoricos.SituacaoMatricula;
import com.allankardeconline.globalkardec.model.categoricos.VinculoMatricula;
import com.allankardeconline.globalkardec.repository.DiaAulaCalendarioRepository;
import com.allankardeconline.globalkardec.repository.MatriculaRepository;
import com.allankardeconline.globalkardec.repository.MatriculaRepositoryCustomizado;
import com.allankardeconline.globalkardec.repository.MatriculasTurmaFrequenciaDiaRepository;
import com.allankardeconline.globalkardec.repository.PessoaRepository;
import com.allankardeconline.globalkardec.repository.SituacaoFrequenciaRepository;
import com.allankardeconline.globalkardec.repository.SituacaoMatriculaRepository;
import com.allankardeconline.globalkardec.repository.TurmaRepository;
import com.allankardeconline.globalkardec.repository.VinculoMatriculaRepository;

import jakarta.transaction.Transactional;

@Service
public class MatriculaService {

	private Logger log = Logger.getLogger(MatriculaService.class.getName());

	@Autowired
	MatriculaRepository repository;

	@Autowired
	MatriculaRepositoryCustomizado repositoryCustomizado;

	@Autowired
	PessoaRepository pessoaRepository;

	@Autowired
	TurmaRepository turmaRepository;

	@Autowired
	VinculoMatriculaRepository vinculoMatriculaRepository;

	@Autowired
	SituacaoMatriculaRepository situacaoMatriculaRepository;

	@Autowired
	SituacaoFrequenciaRepository situacaoFrequenciaRepository;

	@Autowired
	DiaAulaCalendarioRepository diaAulaCalendarioRepository;

	@Autowired
	MatriculasTurmaFrequenciaDiaRepository matriculaTurmaFrequenciaDiaRepository;

	@Autowired
	ConfiguracaoGeralGlobalKardec configuracao;

	public Page<MatriculaConsultaDTO> obterPorPessoa(UUID uuidPessoa,
			Pageable paginacao) {
		var page = repository.obterMatriculasPorPessoa(uuidPessoa, paginacao);

		var pagesDTO = page.map(objeto -> DozerMapper.parseObject(objeto,
				MatriculaConsultaDTO.class));
		return pagesDTO;
	}

	public Page<MatriculaConsultaDTO> obterMatriculasAtivasPorPessoa(
			UUID uuidPessoa, Pageable paginacao) {
		var page = repository.obterMatriculasAtivasPorPessoa(uuidPessoa, 1l,
				paginacao);

		var pagesDTO = page.map(objeto -> DozerMapper.parseObject(objeto,
				MatriculaConsultaDTO.class));
		return pagesDTO;
	}

	public Page<MatriculaConsultaDTO> obterMatriculasPorParametros(
			UUID uuidCentroEspirita, UUID uuidCalendario, UUID uuidCurso,
			String aluno, Long idVinculo, Pageable paginacao) {
		var page = repositoryCustomizado.pesquisar(uuidCentroEspirita,
				uuidCalendario, uuidCurso, aluno, idVinculo, paginacao);

		var pagesDTO = page.map(objeto -> DozerMapper.parseObject(objeto,
				MatriculaConsultaDTO.class));
		return pagesDTO;
	}

	public Page<MatriculaConsultaDTO> obterPorNomePessoa(String nomePessoa,
			Pageable paginacao) {
		var page = repository.obterMatriculasPorNomePessoa(nomePessoa,
				paginacao);

		var pagesDTO = page.map(objeto -> DozerMapper.parseObject(objeto,
				MatriculaConsultaDTO.class));
		return pagesDTO;
	}

	public List<MatriculaConsultaDTO> obterPorTurma(UUID uuidTurma) {

		return DozerMapper.parseListObjects(
				repository.obterMatriculasPorTurma(uuidTurma),
				MatriculaConsultaDTO.class);

	}

	public List<MatriculaConsultaDTO> obterAtivasPorPessoa(UUID uuidPessoa) {

		return DozerMapper.parseListObjects(
				repository.obterMatriculasAtivasPorPessoa(uuidPessoa),
				MatriculaConsultaDTO.class);

	}

	public List<MatriculaConsultaDTO> obterInativasPorPessoa(UUID uuidPessoa) {

		return DozerMapper.parseListObjects(
				repository.obterMatriculasInativasPorPessoa(uuidPessoa),
				MatriculaConsultaDTO.class);

	}

	public MatriculaDTO obterPorUuid(UUID uuid) {

		var entity = repository.findByUuid(uuid);

		if (entity == null)
			throw new RecursoNaoEncontradoException(
					"Objeto não encontrado para o id ");

		return DozerMapper.parseObject(entity, MatriculaDTO.class);

	}

	@Transactional
	public void inserirMatriculaLoteTurmaEncerrada(LoteMatriculaDTO lote) {

		Turma turmaEncerrada = turmaRepository
				.findByUuid(lote.getUuidTurmaEncerrada())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"TurmaEncerrada não encontrada para o uuid "
								+ lote.getUuidTurmaEncerrada()));

		Turma turmaNovaAprovados = turmaRepository
				.findByUuid(lote.getUuidNovaTurmaAprovados())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"TurmaNovaAprovados não encontrada para o uuid "
								+ lote.getUuidNovaTurmaAprovados()));

		Turma turmaNovaRerovados = turmaRepository
				.findByUuid(lote.getUuidNovaTurmaReprovados())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"TurmaNovaReprovados não encontrada para o uuid "
								+ lote.getUuidNovaTurmaReprovados()));

		List<Matricula> matriculas = repository
				.obterMatriculasPorTurma(lote.getUuidTurmaEncerrada());

		matriculas.forEach(matricula -> {

			Matricula novaMatricula = new Matricula();

			novaMatricula.setUuid(UUID.randomUUID());
			novaMatricula.setDataInicio(lote.getDataInicio());
			novaMatricula.setPessoa(matricula.getPessoa());
			novaMatricula.setSituacaoMatricula(SituacaoMatricula.MATRICULADO);
			novaMatricula.setVinculoMatricula(matricula.getVinculoMatricula());

			if (matricula.getSituacaoMatricula().getId()
					.equals(SituacaoMatricula.APROVADO.getId())) {
				novaMatricula.setTurma(turmaNovaAprovados);
			} else {
				novaMatricula.setTurma(turmaNovaRerovados);
			}

			repository.save(novaMatricula);

		});

	}

	public MatriculaDTO inserir(MatriculaCadastroDTO dto) {

		var entity = DozerMapper.parseObject(dto, Matricula.class);

		Matricula matricula = repository
				.obterMatriculaPorTurmaEPessoa(dto.getTurma(), dto.getPessoa());

		if (matricula != null)
			throw new DuplicidadeException("Aluno já matriculado na turma");

		Pessoa pessoa = pessoaRepository.findByUuid(dto.getPessoa())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Pessoa não encontrada para o uuid "
								+ dto.getPessoa()));

		Turma turma = turmaRepository.findByUuid(dto.getTurma())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Turma não encontrada para o uuid " + dto.getTurma()));

		VinculoMatricula vinculo = vinculoMatriculaRepository
				.findById(dto.getVinculoMatricula())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"VinculoMatricula não encontrada para o uuid "
								+ dto.getVinculoMatricula()));

		SituacaoMatricula situacao = situacaoMatriculaRepository
				.findById(configuracao.getIdSituacaoMatriculado())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"SituacaoMatricula não encontrada para o uuid "
								+ configuracao.getIdSituacaoMatriculado()));

		entity.setUuid(UUID.randomUUID());
		entity.setPessoa(pessoa);
		entity.setTurma(turma);
		entity.setVinculoMatricula(vinculo);
		entity.setSituacaoMatricula(situacao);
		entity.setObservacao(dto.getObservacao());
		entity.setDataInicio(dto.getDataInicio());

		var dtoRetorno = DozerMapper.parseObject(repository.save(entity),
				MatriculaDTO.class);

		return dtoRetorno;

	}

	public MatriculaDTO alterar(MatriculaCadastroDTO dto) {

		Matricula entity = repository.findByUuid(dto.getUuid())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Matricula não encontrada para o uuid "
								+ dto.getUuid()));

		if (entity == null)
			throw new RecursoNaoEncontradoException(
					"Objeto não encontrado para o id ");

		Pessoa pessoa = pessoaRepository.findByUuid(dto.getPessoa())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Pessoa não encontrada para o uuid "
								+ dto.getPessoa()));

		Turma turma = turmaRepository.findByUuid(dto.getTurma())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Turma não encontrada para o uuid " + dto.getTurma()));

		VinculoMatricula vinculo = vinculoMatriculaRepository
				.findById(dto.getVinculoMatricula())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"VinculoMatricula não encontrada para o uuid "
								+ dto.getVinculoMatricula()));

		SituacaoMatricula situacao = situacaoMatriculaRepository
				.findById(configuracao.getIdSituacaoMatriculado())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"SituacaoMatricula não encontrada para o uuid "
								+ configuracao.getIdSituacaoMatriculado()));

		entity.setPessoa(pessoa);
		entity.setTurma(turma);
		entity.setVinculoMatricula(vinculo);
		entity.setSituacaoMatricula(situacao);
		entity.setObservacao(dto.getObservacao());
		entity.setDataInicio(dto.getDataInicio());

		var vo = DozerMapper.parseObject(repository.save(entity),
				MatriculaDTO.class);

		return vo;

	}

	public void excluir(UUID id) {
		Matricula entity = repository.findByUuid(id)
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Matricula não encontrada para o uuid " + id));

		repository.delete(entity);
	}

	public MatriculaDTO registrarDesistencia(
			MatriculaDesistenciaDTO matricula) {

		Matricula entity = repository.findByUuid(matricula.getUuid())
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Matricula não encontrada para o uuid "
								+ matricula.getUuid()));

		SituacaoMatricula situacao = situacaoMatriculaRepository.findById(4l)
				.orElse(null);

		entity.setDataEncerramento(matricula.getData().toInstant()
				.atZone(ZoneId.systemDefault()).toLocalDate());
		entity.setSituacaoMatricula(situacao);

		return DozerMapper.parseObject(repository.save(entity),
				MatriculaDTO.class);

	}

	public MatriculaDTO reativarMatricula(UUID matricula) {

		Matricula entity = repository.findByUuid(matricula)
				.orElseThrow(() -> new RecursoNaoEncontradoException(
						"Matricula não encontrada para o uuid " + matricula));

		SituacaoMatricula situacao = situacaoMatriculaRepository.findById(1l)
				.orElse(null);

		entity.setDataEncerramento(null);
		entity.setSituacaoMatricula(situacao);

		return DozerMapper.parseObject(repository.save(entity),
				MatriculaDTO.class);

	}

}
