package com.allankardeconline.globalkardec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allankardeconline.globalkardec.dto.ConfiguracaoGlobalKardecDTO;
import com.allankardeconline.globalkardec.services.ConfiguracaoGlobalKardecService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/gk/config")
@Tag(name = "Configurações", description = "Endpoints para configurações gerais do sistema")
public class ConfiguracaoGlobalKardecController {

	@Autowired
	private ConfiguracaoGlobalKardecService service;

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Altera a configuração", tags = {
			"Configurações"
	}, responses = {
			@ApiResponse
	})
	public ConfiguracaoGlobalKardecDTO alterar(
			@RequestBody ConfiguracaoGlobalKardecDTO configuracao) {
		return service.alterar(configuracao);
	}

}
