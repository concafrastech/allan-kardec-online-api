package com.allankardeconline.globalkardec.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.allankardeconline.globalkardec.dto.PessoaCadastroDTO;
import com.allankardeconline.globalkardec.dto.PessoaConsultaDTO;
import com.allankardeconline.globalkardec.dto.PessoaDTO;
import com.allankardeconline.globalkardec.services.PessoaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/gk/pessoa")
@Tag(name = "Pessoa", description = "Endpoints para gerenciar pessoas")
public class PessoaController {

	@Autowired
	private PessoaService service;

	@GetMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Pessoa por uuid", tags = {
			"Pessoa"
	}, responses = {
			@ApiResponse
	})
	public PessoaDTO obterPorUuid(@PathVariable UUID uuid) {
		return service.obterPorUuid(uuid);
	}

	@GetMapping(value = "/porNome", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Lista de pessoas por nome", tags = {
			"Pessoa"
	}, responses = {
			@ApiResponse
	})
	public ResponseEntity<Page<PessoaDTO>> obterPorNome(
			@RequestParam(name = "nome", defaultValue = "") String nome,
			@RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
			@RequestParam(value = "limite", defaultValue = "10") Integer limite) {

		Pageable paginacao = PageRequest.of(pagina, limite);

		return ResponseEntity.ok(service.obterPorNome(nome, paginacao));
	}

	@GetMapping(value = "/porEmailOuTelefone", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Lista de pessoas por E-mail OU Telefone", tags = {
			"Pessoa"
	}, responses = {
			@ApiResponse
	})
	public List<PessoaDTO> obterPorTelefoneOuEmail(
			@RequestParam(name = "email", defaultValue = "") String email,
			@RequestParam(name = "telefone", defaultValue = "") String telefone) {

		return service.obterPorEmailOUTelefone(email, telefone);
	}

	@GetMapping(value = "/porCentro/{uuidCentro}/porNomeOuEmailOuTelefone", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Lista de pessoas de um centro filtradas por Nome E/OU E-mail E/OU Telefone", tags = {
			"Pessoa"
	}, responses = {
			@ApiResponse
	})
	public List<PessoaConsultaDTO> obterPorCentroENomeOUEmailOUTelefone(
			@PathVariable UUID uuidCentro,
			@RequestParam(name = "campoBusca", defaultValue = "") String campoBusca) {

		return service.obterPorCentroENomeOUEmailOUTelefone(uuidCentro,
				campoBusca);
	}

	@GetMapping(value = "/porCentro/{uuidCentro}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Todas as pessoas por centro", tags = {
			"Pessoa"
	}, responses = {
			@ApiResponse
	})
	public ResponseEntity<Page<PessoaDTO>> obterTodos(
			@PathVariable UUID uuidCentro,
			@RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
			@RequestParam(value = "limite", defaultValue = "10") Integer limite) {

		Pageable paginacao = PageRequest.of(pagina, limite);

		return ResponseEntity.ok(service.obterTodos(paginacao));
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Inserir uma nova pessoa", tags = {
			"Pessoa"
	}, responses = {
			@ApiResponse
	})
	@ResponseStatus(HttpStatus.CREATED)
	public PessoaDTO inserir(@RequestBody @Valid PessoaCadastroDTO pessoa) {
		return service.inserir(pessoa);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Atualizar dados de uma pessoa", tags = {
			"Pessoa"
	}, responses = {
			@ApiResponse
	})
	public PessoaDTO alterar(@RequestBody PessoaCadastroDTO pessoa) {
		return service.alterar(pessoa);
	}

	@DeleteMapping(value = "/{uuid}")
	@Operation(summary = "Permite a exclusão de uma pessoa por uuid", tags = {
			"Pessoa"
	}, responses = {
			@ApiResponse
	})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> excluir(@PathVariable UUID uuid) {
		service.excluir(uuid);
		return ResponseEntity.noContent().build();
	}

}
