package com.allankardeconline.globalkardec.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.allankardeconline.globalkardec.dto.CursoConsultaDTO;
import com.allankardeconline.globalkardec.dto.CursoDTO;
import com.allankardeconline.globalkardec.services.ArquivoUploadService;
import com.allankardeconline.globalkardec.services.CursoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/gk/curso")
@CrossOrigin(origins = "http://localhost:4200")
@Tag(name = "Curso", description = "Endpoints para gerenciar cursos")
public class CursoController {

	@Autowired
	private CursoService service;

	@Autowired
	private ArquivoUploadService uploadService;

	@GetMapping(value = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna um curso por uuid", tags = {
			"Curso"
	}, responses = {
			@ApiResponse
	})
	public CursoDTO obterPorUuid(@PathVariable UUID uuid) {
		return service.obterPorUuid(uuid);
	}

	@GetMapping(value = "/porNome", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna uma lista de cursos por nome", tags = {
			"Curso"
	}, responses = {
			@ApiResponse
	})
	public ResponseEntity<Page<CursoConsultaDTO>> obterPorNome(
			@RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
			@RequestParam(value = "limite", defaultValue = "10") Integer limite,
			@RequestParam(name = "nome") String nome) {

		Pageable paginacao = PageRequest.of(pagina, limite);

		return ResponseEntity
				.ok(service.obterPorNome(paginacao, "%" + nome + "%"));
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna todos os cursos", tags = {
			"Curso"
	}, responses = {
			@ApiResponse
	})
	public ResponseEntity<Page<CursoConsultaDTO>> obterTodos(
			@RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
			@RequestParam(value = "limite", defaultValue = "10") Integer limite) {

		Pageable paginacao = PageRequest.of(pagina, limite);

		return ResponseEntity.ok(service.obterTodos(paginacao));
	}

//	@GetMapping(value = "/pesquisar", produces = MediaType.APPLICATION_JSON_VALUE)
//	@Operation(summary = "Permite a pesquisa por parametros pré-estabelecidos", tags = {
//			"Curso"
//	}, responses = {
//			@ApiResponse
//	})
//	public ResponseEntity<Page<CursoDTO>> pesquisar(
//			@RequestParam(value = "pagina", defaultValue = "0") Integer pagina,
//			@RequestParam(value = "limite", defaultValue = "10") Integer limite,
//			@RequestParam(name = "curso", defaultValue = "") String curso,
//			@RequestParam(name = "idioma", defaultValue = "") String idioma,
//			@RequestParam(name = "instituto", defaultValue = "") String instituto) {
//
//		Pageable paginacao = PageRequest.of(pagina, limite);
//
//		return ResponseEntity
//				.ok(service.pesquisar(curso, idioma, instituto, paginacao));
//	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Permite o cadastramento de um novo curso", tags = {
			"Curso"
	}, responses = {
			@ApiResponse
	})
	@ResponseStatus(HttpStatus.CREATED)
	public CursoDTO inserir(@RequestBody @Valid CursoDTO curso) {
		return service.inserir(curso);
	}

	@PostMapping("/envioCapa")
	@Operation(summary = "Permite o envio de uma imagem correspondente à capa do curso", tags = {
			"Curso"
	}, responses = {
			@ApiResponse
	})
	public String envioArquivo(@RequestParam("file") MultipartFile file) {

		var filename = uploadService.gravarArquivo(file);

		return filename;
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Atualiza e retorna um curso", tags = {
			"Curso"
	}, responses = {
			@ApiResponse
	})
	public CursoDTO alterar(@RequestBody CursoDTO curso) {
		return service.alterar(curso);
	}

	@DeleteMapping(value = "/{uuid}")
	@Operation(summary = "Permite a exclusão de curso por uuid", tags = {
			"Curso"
	}, responses = {
			@ApiResponse
	})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> excluir(@PathVariable UUID uuid) {
		service.excluir(uuid);
		return ResponseEntity.noContent().build();
	}

}
