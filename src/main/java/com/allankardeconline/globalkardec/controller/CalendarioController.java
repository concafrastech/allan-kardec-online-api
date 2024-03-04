package com.allankardeconline.globalkardec.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.allankardeconline.globalkardec.dto.CalendarioCompletoDTO;
import com.allankardeconline.globalkardec.dto.CalendarioDTO;
import com.allankardeconline.globalkardec.dto.DiaAulaDTO;
import com.allankardeconline.globalkardec.services.CalendarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/gk/calendario")
@Tag(name = "Calendario", description = "Endpoints para gerenciar calendários de curso.")
public class CalendarioController {

	@Autowired
	private CalendarioService service;

	@GetMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna um calendario por uuid", tags = {
			"Calendario"
	}, responses = {
			@ApiResponse
	})
	public CalendarioCompletoDTO obterPorUuid(@PathVariable UUID uuid) {
		return service.obterPorUuid(uuid);
	}

	@GetMapping(value = "/porCentro/{uuidCentro}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna todos os calendarios por Centro", tags = {
			"Calendario"
	}, responses = {
			@ApiResponse
	})
	public List<CalendarioDTO> obterTodosPorCentro(
			@PathVariable UUID uuidCentro) {
		return service.obterTodosPorCentro(uuidCentro);
	}

	@GetMapping(value = "/dia/{uuidCalendario}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna todos os dias de aula do calendario", tags = {
			"Calendario"
	}, responses = {
			@ApiResponse
	})
	public List<DiaAulaDTO> obterDiasAulaPorCalendario(
			@PathVariable UUID uuidCalendario) {
		return service.obterDiasAulaPorCalendario(uuidCalendario);
	}

	@PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Atualiza e retorna um calendario", tags = {
			"Calendario"
	}, responses = {
			@ApiResponse
	})
	public CalendarioCompletoDTO alterar(
			@RequestBody @Valid CalendarioCompletoDTO calendario) {
		return service.alterar(calendario);
	}

	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Permite o cadastramento de um novo calendario com os dias de aula", tags = {
			"Calendario"
	}, responses = {
			@ApiResponse
	})
	@ResponseStatus(HttpStatus.CREATED)
	public CalendarioCompletoDTO inserir(
			@RequestBody @Valid CalendarioCompletoDTO calendario) {
		return service.inserir(calendario);
	}

	@DeleteMapping(value = "/{uuid}")
	@Operation(summary = "Permite a exclusão de um calendario por uuid", tags = {
			"Calendario"
	}, responses = {
			@ApiResponse
	})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> excluir(@PathVariable UUID uuid) {
		service.excluir(uuid);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value = "/dia/{uuid}")
	@Operation(summary = "Permite a exclusão de um dia no calendario por uuid", tags = {
			"Calendario"
	}, responses = {
			@ApiResponse
	})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> excluirDiaCalendario(@PathVariable UUID uuid) {
		service.excluirDiaCalendario(uuid);
		return ResponseEntity.noContent().build();
	}

}
