package com.allankardeconline.globalkardec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allankardeconline.globalkardec.dto.PreCadastroDTO;
import com.allankardeconline.globalkardec.services.PreCadastroService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/gk/precadastro")
@Tag(name = "Pré-cadastro", description = "Endpoints para gerenciar pré-cadastros")
public class PreCadastroController {

	@Autowired
	private PreCadastroService service;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Inserir um pré-cadastro", tags = {
			"Pré-cadastro"
	}, responses = {
			@ApiResponse
	})
	public PreCadastroDTO inserir(@RequestBody PreCadastroDTO dto) {
		return service.inserir(dto);
	}

}
