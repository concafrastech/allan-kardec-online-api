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

import com.allankardeconline.globalkardec.dto.ItemConteudoDTO;
import com.allankardeconline.globalkardec.services.ItemConteudoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/gk/itemConteudo")
@Tag(name = "ItemConteudo", description = "Endpoints para gerenciar conteudos de curso")
public class ItemConteudoController {

	@Autowired
	private ItemConteudoService service;

	@GetMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna um item de conteudo do curso por uuid", tags = {
			"ItemConteudo"
	}, responses = {
			@ApiResponse
	})
	public ItemConteudoDTO obterPorUuid(@PathVariable UUID uuid) {
		return service.obterPorUuid(uuid);
	}

	@GetMapping(value = "/{uuidCentro}/porConteudo/{uuidConteudo}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna todos os itens de conteudo do curso por centro (global e do centro atual) e conteúdo. ", tags = {
			"ItemConteudo"
	}, responses = {
			@ApiResponse
	})
	public List<ItemConteudoDTO> obterTodosItensGlobaisEConteudoUuid(
			@PathVariable UUID uuidCentro, @PathVariable UUID uuidConteudo) {
		return service.obterTodosItensGlobaisEConteudoUuid(uuidCentro,
				uuidConteudo);
	}

	@PostMapping(value = "/{uuidCentro}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Permite o cadastramento de um novo item conteudo de curso", tags = {
			"ItemConteudo"
	}, responses = {
			@ApiResponse
	})
	@ResponseStatus(HttpStatus.CREATED)
	public ItemConteudoDTO inserir(@PathVariable UUID uuidCentro,
			@RequestBody @Valid ItemConteudoDTO itemConteudo) {

		return service.inserir(itemConteudo, uuidCentro);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Atualiza e retorna um item de conteudo do curso", tags = {
			"ItemConteudo"
	}, responses = {
			@ApiResponse
	})
	public ItemConteudoDTO alterar(@RequestBody ItemConteudoDTO itemConteudo) {
		return service.alterar(itemConteudo);
	}

	@DeleteMapping(value = "/{uuid}")
	@Operation(summary = "Permite a exclusão de um item de conteudo por uuid", tags = {
			"ItemConteudo"
	}, responses = {
			@ApiResponse
	})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> excluir(@PathVariable UUID uuid) {
		service.excluir(uuid);
		return ResponseEntity.noContent().build();
	}

}
