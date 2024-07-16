package com.allankardeconline.globalkardec.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.allankardeconline.globalkardec.dto.FrequenciaAlunoConsultaDTO;
import com.allankardeconline.globalkardec.dto.FrequenciaAlunoIndividualDTO;
import com.allankardeconline.globalkardec.dto.FrequenciaAlunoTurmaEncerramentoDTO;
import com.allankardeconline.globalkardec.dto.ListaFrequenciaAlunoDTO;
import com.allankardeconline.globalkardec.dto.MatriculadosTurmaFrequenciaDiaDTO;
import com.allankardeconline.globalkardec.services.FrequenciaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/gk/frequencia")
@Tag(name = "Frequência", description = "Endpoints para gerenciar frequência dos alunos.")
public class FrequenciaController {

	@Autowired
	private FrequenciaService service;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Registro de frequência", tags = {
			"Frequência"
	}, responses = {
			@ApiResponse
	})
	@ResponseStatus(HttpStatus.CREATED)
	public void registrarFrequencia(
			@RequestBody @Valid ListaFrequenciaAlunoDTO frequencia) {
		service.registrarFrequencia(frequencia);
	}

	@PostMapping(value = "/aluno", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Registro de frequência a partir da matricula e dia calendário", tags = {
			"Frequência"
	}, responses = {
			@ApiResponse
	})
	@ResponseStatus(HttpStatus.CREATED)
	public void registrarFrequenciaPeloAluno(@RequestBody @Valid FrequenciaAlunoIndividualDTO frequencia) {
		service.registrarFrequenciaPeloAluno(frequencia);
	}

	@GetMapping(value = "/porCalendario/{uuidCalendario}/{dataAula}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Lista de frequências por calendário e data", tags = {
			"Frequência"
	}, responses = {
			@ApiResponse
	})
	public List<MatriculadosTurmaFrequenciaDiaDTO> obterFrequenciaMatriculadosPorCalendarioEData(
			@PathVariable UUID uuidCalendario, @PathVariable String dataAula) {

		return service.obterFrequenciaMatriculadosPorCalendarioEData(
				uuidCalendario, dataAula);
	}

	@GetMapping(value = "/porTurma/{uuidTurma}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Lista de frequências por turma uuid", tags = {
			"Frequência"
	}, responses = {
			@ApiResponse
	})
	public List<FrequenciaAlunoTurmaEncerramentoDTO> obterFrequenciaAlunoTurmaEncerramento(
			@PathVariable UUID uuidTurma) {

		return service.obterFrequenciaAlunoTurmaEncerramento(uuidTurma);
	}

	@GetMapping(value = "/porMatricula/{uuidMatricula}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Lista de frequências por matricula uuid", tags = {
			"Frequência"
	}, responses = {
			@ApiResponse
	})
	public List<FrequenciaAlunoConsultaDTO> obterFrequenciaAlunoPorMatricula(
			@PathVariable UUID uuidMatricula) {

		return service.obterFrequenciaPorMatricula(uuidMatricula);
	}

	@GetMapping(value = "/porTurmaEDia/{uuidTurma}/{uuidDiaCalendario}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Lista de frequências por uuid da turma e do dia no calendário", tags = {
			"Frequência"
	}, responses = {
			@ApiResponse
	})
	public List<FrequenciaAlunoConsultaDTO> obterFrequenciaAlunoPorTurmaEDia(
			@PathVariable UUID uuidTurma,
			@PathVariable UUID uuidDiaCalendario) {

		return service.obterFrequenciasPorTurmaEDia(uuidTurma,
				uuidDiaCalendario);
	}
}
