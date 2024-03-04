package com.allankardeconline.globalkardec.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

import com.allankardeconline.globalkardec.dto.LoteTurmaDTO;
import com.allankardeconline.globalkardec.dto.TurmaDTO;
import com.allankardeconline.globalkardec.excecoes.CadastroDependenteException;
import com.allankardeconline.globalkardec.services.TurmaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/gk/turma")
@Tag(name = "Turma", description = "Endpoints para gerenciar turmas")
public class TurmaController {

	@Autowired
	private TurmaService service;

	@GetMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna uma turma por uuid", tags = {
			"Turma"
	}, responses = {
			@ApiResponse
	})
	public TurmaDTO obterPorUuid(@PathVariable UUID uuid) {
		return service.obterPorUuid(uuid);
	}

	@GetMapping(value = "/nocoesBasicasAtiva", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna a turma do curso noções básicas que está ativa", tags = {
			"Turma"
	}, responses = {
			@ApiResponse
	})
	public TurmaDTO obterTurmaNocoesBasicas() {
		return service.obterTurmaNocoesBasicasAtiva();
	}

	@GetMapping(value = "/porCentro/{uuidCentro}/porNomeCurso/", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna uma lista de turmas de um centro por nome do curso", tags = {
			"Turma"
	}, responses = {
			@ApiResponse
	})
	public ResponseEntity<Page<TurmaDTO>> obterPorNomeCurso(
			@PathVariable UUID uuidCentro,
			@RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
			@RequestParam(value = "limite", defaultValue = "10") Integer limite,
			@RequestParam(name = "nome") String nomeCurso) {

		Pageable paginacao = PageRequest.of(pagina, limite);

		return ResponseEntity.ok(service.obterPorCentroENomeCurso(uuidCentro,
				nomeCurso, paginacao));
	}

	@GetMapping(value = "/porCentro/{uuidCentro}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna todas as turmas por centro", tags = {
			"Turma"
	}, responses = {
			@ApiResponse
	})
	public ResponseEntity<Page<TurmaDTO>> obterTodos(
			@PathVariable UUID uuidCentro,
			@RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
			@RequestParam(value = "limite", defaultValue = "10") Integer limite) {

		Pageable paginacao = PageRequest.of(pagina, limite);

		return ResponseEntity
				.ok(service.obterTodosPorCentro(uuidCentro, paginacao));
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Permite o cadastramento de uma nova turma", tags = {
			"Turma"
	}, responses = {
			@ApiResponse
	})
	@ResponseStatus(HttpStatus.CREATED)
	public TurmaDTO inserir(@RequestBody @Valid TurmaDTO turma) {
		return service.inserir(turma);
	}

	@PostMapping(value = "/lote", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Cadastro de turmas em lote", tags = {
			"Turma"
	}, responses = {
			@ApiResponse
	})
	@ResponseStatus(HttpStatus.CREATED)
	public List<TurmaDTO> inserirTurmaEmLote(
			@RequestBody @Valid LoteTurmaDTO turmaEmLote) {
		return service.inserirTurmaEmLote(turmaEmLote);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna a atualização de uma turma", tags = {
			"Turma"
	}, responses = {
			@ApiResponse
	})
	public TurmaDTO alterar(@RequestBody TurmaDTO turma) {
		return service.alterar(turma);
	}

	@DeleteMapping(value = "/{uuid}")
	@Operation(summary = "Permite a exclusão de uma turma por uuid", tags = {
			"Turma"
	}, responses = {
			@ApiResponse
	})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> excluir(@PathVariable UUID uuid) {
		try {
			service.excluir(uuid);
		} catch (DataIntegrityViolationException e) {
			throw new CadastroDependenteException(
					"A turma não pode ser exclúida pois está vinculada a outro registro.");
		}
		return ResponseEntity.noContent().build();
	}

	@PatchMapping(value = "/encerrar/{uuid}")
	@Operation(summary = "Encerrar a turma e registrar aprovações.", tags = {
			"Turma"
	}, responses = {
			@ApiResponse
	})
	@ResponseStatus(HttpStatus.OK)
	public void encerrarTurma(@PathVariable UUID uuid) {

		service.encerrarTurma(uuid);
	}

	@PatchMapping(value = "/reabrir/{uuid}")
	@Operation(summary = "Reabrir turma a partir do uuid", tags = {
			"Turma"
	}, responses = {
			@ApiResponse
	})
	@ResponseStatus(HttpStatus.OK)
	public void reativarMatricula(@PathVariable UUID uuid) {

		service.reabrirTurma(uuid);
	}
}
