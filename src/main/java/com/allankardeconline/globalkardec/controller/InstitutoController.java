package com.allankardeconline.globalkardec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.allankardeconline.globalkardec.dto.InstitutoDTO;
import com.allankardeconline.globalkardec.services.InstitutoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/gk/instituto")
@Tag(name = "Instituto", description = "Endpoints para gerenciar institutos")
public class InstitutoController {

	@Autowired
	private InstitutoService service;

//	@GetMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
//	@Operation(summary = "Retorna um instituto por uuid", tags = {
//			"Instituto"
//	}, responses = {
//			@ApiResponse
//	})
//	public InstitutoDTO obterPorUuid(@PathVariable UUID uuid) {
//		return service.obterPorUuid(uuid);
//	}

	@GetMapping(value = "/porNome", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna uma lista de institutos por nome", tags = {
			"Instituto"
	}, responses = {
			@ApiResponse
	})
	public List<InstitutoDTO> obterPorNome(
			@RequestParam(name = "nome") String nome) {
		return service.obterPorNome("%" + nome + "%");
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna todos os institutos", tags = {
			"Instituto"
	}, responses = {
			@ApiResponse
	})
	public List<InstitutoDTO> obterTodos() {
		return service.obterTodos();
	}

//	@GetMapping(value = "/pesquisarPorExemplo", produces = MediaType.APPLICATION_JSON_VALUE)
//	public List<InstitutoDTO> pesquisarPorExemplo(InstitutoDTO filtro) {
//		return service.pesquisarPorExemplo(filtro);
//
//	}

//	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	@Operation(summary = "Permite o cadastramento de um novo instituto", tags = {
//			"Instituto"
//	}, responses = {
//			@ApiResponse
//	})
//	@ResponseStatus(HttpStatus.CREATED)
//	public InstitutoDTO inserir(@RequestBody @Valid InstitutoDTO instituto) {
//		return service.inserir(instituto);
//	}
//
//	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//	@Operation(summary = "Atualiza e retorna um instituto", tags = {
//			"Instituto"
//	}, responses = {
//			@ApiResponse
//	})
//	public InstitutoDTO alterar(@RequestBody InstitutoDTO instituto) {
//		return service.alterar(instituto);
//	}
//
//	@DeleteMapping(value = "/{uuid}")
//	@Operation(summary = "Permite a exclusão de um instituto por uuid", tags = {
//			"Instituto"
//	}, responses = {
//			@ApiResponse
//	})
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public ResponseEntity<?> excluir(@PathVariable UUID uuid) {
//		service.excluir(uuid);
//		return ResponseEntity.noContent().build();
//	}

}
