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

import com.allankardeconline.globalkardec.dto.ConteudoDTO;
import com.allankardeconline.globalkardec.services.ConteudoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/gk/conteudo")
@Tag(name = "Conteudo", description = "Endpoints para gerenciar conteúdos do curso")
public class ConteudoController {

	@Autowired
	private ConteudoService service;

	@GetMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna um conteúdo por uuid", tags = {
			"Conteudo"
	}, responses = {
			@ApiResponse
	})
	public ConteudoDTO obterPorUuid(@PathVariable UUID uuid) {
		return service.obterPorUuid(uuid);
	}

	@GetMapping(value = "/porCurso/{cursoUuid}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna todos os conteúdos do curso", tags = {
			"Conteudo"
	}, responses = {
			@ApiResponse
	})
	public List<ConteudoDTO> obterTodosPorCurso(@PathVariable UUID cursoUuid) {
		return service.obterTodosPorCurso(cursoUuid);
	}

	@PostMapping(value = "lote", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Permite o cadastramento de uma lista de conteudos", tags = {
			"Conteudo"
	}, responses = {
			@ApiResponse
	})
	@ResponseStatus(HttpStatus.CREATED)
	public void inserirLote(@RequestBody @Valid List<ConteudoDTO> conteudos) {
		service.inserirLote(conteudos);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Permite o cadastramento de um novo conteudo", tags = {
			"Conteudo"
	}, responses = {
			@ApiResponse
	})
	@ResponseStatus(HttpStatus.CREATED)
	public ConteudoDTO inserir(@RequestBody @Valid ConteudoDTO conteudo) {
		return service.inserir(conteudo);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Atualiza e retorna um conteúdo", tags = {
			"Conteudo"
	}, responses = {
			@ApiResponse
	})
	public ConteudoDTO alterar(@RequestBody ConteudoDTO conteudo) {
		return service.alterar(conteudo);
	}

	@DeleteMapping(value = "/{uuid}")
	@Operation(summary = "Permite a exclusão de conteudo por uuid", tags = {
			"Conteudo"
	}, responses = {
			@ApiResponse
	})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> excluir(@PathVariable(name = "uuid") UUID uuid) {
		service.excluir(uuid);
		return ResponseEntity.noContent().build();
	}

}
