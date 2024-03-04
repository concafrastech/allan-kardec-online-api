package com.allankardeconline.globalkardec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.allankardeconline.globalkardec.dto.CentroEspiritaDTO;
import com.allankardeconline.globalkardec.services.CentroEspiritaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/gk/centroespirita")
@Tag(name = "CentroEspirita", description = "Endpoints para consulta centro espírita")
public class CentroEspiritaController {

	@Autowired
	private CentroEspiritaService service;

	@GetMapping(value = "/porNome", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna uma lista de centros espíritas por nome", tags = {
			"CentroEspirita"
	}, responses = {
			@ApiResponse
	})
	public List<CentroEspiritaDTO> obterPorNome(
			@RequestParam(name = "nome") String nome) {
		return service.obterPorNome("%" + nome + "%");
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna todos os centros espíritas", tags = {
			"CentroEspirita"
	}, responses = {
			@ApiResponse
	})
	public List<CentroEspiritaDTO> obterTodos() {
		return service.obterTodos();
	}

}
