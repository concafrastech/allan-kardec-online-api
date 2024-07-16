package com.allankardeconline.globalkardec.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.allankardeconline.globalkardec.dto.LoteMatriculaDTO;
import com.allankardeconline.globalkardec.dto.MatriculaCadastroDTO;
import com.allankardeconline.globalkardec.dto.MatriculaConsultaDTO;
import com.allankardeconline.globalkardec.dto.MatriculaDTO;
import com.allankardeconline.globalkardec.dto.MatriculaDesistenciaDTO;
//import com.allankardeconline.globalkardec.services.MatriculaService;
import com.allankardeconline.globalkardec.services.MatriculaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/gk/matricula")
@Tag(name = "Matricula", description = "Endpoints para gerenciar matriculas.")
public class MatriculaController {

	@Autowired
	private MatriculaService service;

	@GetMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Matricula por uuid", tags = {
			"Matricula"
	}, responses = {
			@ApiResponse
	})
	public MatriculaDTO obterPorUuid(@PathVariable UUID uuid) {
		return service.obterPorUuid(uuid);
	}

	@GetMapping(value = "/porPessoa/todas/{uuidPessoa}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Matriculas (todas) por uuid da pessoa", tags = {
			"Matricula"
	}, responses = {
			@ApiResponse
	})
	public Page<MatriculaConsultaDTO> obterPorPessoa(
			@PathVariable UUID uuidPessoa,
			@RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
			@RequestParam(value = "limite", defaultValue = "10") Integer limite) {

		Pageable paginacao = PageRequest.of(pagina, limite);

		return service.obterPorPessoa(uuidPessoa, paginacao);
	}

	@GetMapping(value = "/pesquisar", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Matriculas por parâmetros de pesquisa", tags = {
			"Matricula"
	}, responses = {
			@ApiResponse
	})
	public Page<MatriculaConsultaDTO> obterPorParametrosPesquisa(
			@RequestParam(name = "uuidCentroEspirita", defaultValue = "") UUID uuidCentroEspirita,
			@RequestParam(name = "uuidCalendario", defaultValue = "") UUID uuidCalendario,
			@RequestParam(name = "uuidCurso", defaultValue = "") UUID uuidCurso,
			@RequestParam(name = "aluno", defaultValue = "") String aluno,
			@RequestParam(name = "idVinculo", defaultValue = "") Long idVinculo,
			@RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
			@RequestParam(value = "limite", defaultValue = "10") Integer limite) {

		Pageable paginacao = PageRequest.of(pagina, limite);

		return service.obterMatriculasPorParametros(uuidCentroEspirita,
				uuidCalendario, uuidCurso, aluno, idVinculo, paginacao);
	}

	@GetMapping(value = "/porPessoa/vigente/{uuidPessoa}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Matriculas VIGENTES por pessoa", tags = {
			"Matricula"
	}, responses = {
			@ApiResponse
	})
	public List<MatriculaConsultaDTO> obterMatriculasVigentesPorPessoa(
			@PathVariable UUID uuidPessoa) {

		return service.obterAtivasPorPessoa(uuidPessoa);
	}

	@GetMapping(value = "/porPessoa/historico/{uuidPessoa}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Matriculas VIGENTES por pessoa", tags = {
			"Matricula"
	}, responses = {
			@ApiResponse
	})
	public List<MatriculaConsultaDTO> obterMatriculasHistoricoPorPessoa(
			@PathVariable UUID uuidPessoa) {

		return service.obterInativasPorPessoa(uuidPessoa);
	}

	@GetMapping(value = "/ativo/{uuidPessoa}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Matriculas ativas por uuid da pessoa", tags = {
			"Matricula"
	}, responses = {
			@ApiResponse
	})
	public Page<MatriculaConsultaDTO> obterMatriculasAtivasPorPessoa(
			@PathVariable UUID uuidPessoa,
			@RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
			@RequestParam(value = "limite", defaultValue = "10") Integer limite) {

		Pageable paginacao = PageRequest.of(pagina, limite);

		return service.obterMatriculasAtivasPorPessoa(uuidPessoa, paginacao);
	}

	@GetMapping(value = "/porNomePessoa/", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Matriculas por nome da pessoa", tags = {
			"Matricula"
	}, responses = {
			@ApiResponse
	})
	public Page<MatriculaConsultaDTO> obterPorNomePessoa(
			@RequestParam(name = "nome", defaultValue = "") String nome,
			@RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
			@RequestParam(value = "limite", defaultValue = "10") Integer limite) {

		Pageable paginacao = PageRequest.of(pagina, limite);

		return service.obterPorNomePessoa(nome, paginacao);
	}

	@GetMapping(value = "/porTurma/{uuidTurma}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Matriculas por turma", tags = {
			"Matricula"
	}, responses = {
			@ApiResponse
	})
	public List<MatriculaConsultaDTO> obterPorTurma(
			@PathVariable UUID uuidTurma) {

		return service.obterPorTurma(uuidTurma);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Registrar matrícula individual", tags = {
			"Matricula"
	}, responses = {
			@ApiResponse
	})
	@ResponseStatus(HttpStatus.CREATED)
	public MatriculaDTO inserir(
			@RequestBody @Valid MatriculaCadastroDTO matricula) {
		return service.inserir(matricula);
	}

	@PostMapping(value = "/lote", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Registrar matrícula em lote a partir de turmas encerradas", tags = {
			"Matricula"
	}, responses = {
			@ApiResponse
	})
	@ResponseStatus(HttpStatus.CREATED)
	public void inserirMatriculaLoteTurmaEncerrada(
			@RequestBody @Valid LoteMatriculaDTO lote) {
		service.inserirMatriculaLoteTurmaEncerrada(lote);
	}

	// obterFrequenciasPorTurmaEDiaAula

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Atualiza e retorna uma matricula", tags = {
			"Matricula"
	}, responses = {
			@ApiResponse
	})
	public MatriculaDTO alterar(@RequestBody MatriculaCadastroDTO matricula) {
		return service.alterar(matricula);

	}

	@PatchMapping(value = "/desistir")
	@Operation(summary = "Registrar desistência matricula", tags = {
			"Matricula"
	}, responses = {
			@ApiResponse
	})
	@ResponseStatus(HttpStatus.OK)
	public MatriculaDTO desativarMatricula(
			@RequestBody MatriculaDesistenciaDTO matricula) {

		return service.registrarDesistencia(matricula);
	}

	@PatchMapping(value = "/reativar/{uuid}")
	@Operation(summary = "Reativar matricula a partir do uuid", tags = {
			"Matricula"
	}, responses = {
			@ApiResponse
	})
	@ResponseStatus(HttpStatus.OK)
	public MatriculaDTO reativarMatricula(@PathVariable UUID uuid) {

		return service.reativarMatricula(uuid);
	}

}
