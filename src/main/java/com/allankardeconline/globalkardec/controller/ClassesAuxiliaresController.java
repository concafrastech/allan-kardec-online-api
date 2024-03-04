package com.allankardeconline.globalkardec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allankardeconline.globalkardec.dto.CidadeDTO;
import com.allankardeconline.globalkardec.dto.ConteudoDTO;
import com.allankardeconline.globalkardec.dto.EstadoProvinciaDTO;
import com.allankardeconline.globalkardec.dto.IdiomaDTO;
import com.allankardeconline.globalkardec.dto.InstitutoDTO;
import com.allankardeconline.globalkardec.dto.PaisDTO;
import com.allankardeconline.globalkardec.dto.SituacaoMatriculaDTO;
import com.allankardeconline.globalkardec.dto.TipoCursoDTO;
import com.allankardeconline.globalkardec.dto.TipoDiaCalendarioDTO;
import com.allankardeconline.globalkardec.dto.TipoRecursoAulaDTO;
import com.allankardeconline.globalkardec.dto.VinculoMatriculaDTO;
import com.allankardeconline.globalkardec.services.ComboService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/gk/auxiliares")
@Tag(name = "ClassesAuxiliares", description = "Endpoints para métodos classes auxiliares do sistema.")
public class ClassesAuxiliaresController {

	@Autowired
	private ComboService service;

	@GetMapping(value = "/obterCategoriaMateria", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna a lista de categoria de matérias", tags = {
			"ClassesAuxiliares"
	}, responses = {
			@ApiResponse
	})
	public List<ConteudoDTO> obterCategoriaMateria() {
		return service.obterCategoriaMateria();
	}

	@GetMapping(value = "/obterInstitutos", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna a lista de institutos", tags = {
			"ClassesAuxiliares"
	}, responses = {
			@ApiResponse
	})
	public List<InstitutoDTO> obterInstitutos() {
		return service.obterInstitutos();
	}

	@GetMapping(value = "/obterSituacaoMatricula", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna a lista de situação de matrícula", tags = {
			"ClassesAuxiliares"
	}, responses = {
			@ApiResponse
	})
	public List<SituacaoMatriculaDTO> obterSituacaoMatricula() {
		return service.obterSituacaoMatricula();
	}

	@GetMapping(value = "/obterTipoCurso", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna a lista de tipos de curso", tags = {
			"ClassesAuxiliares"
	}, responses = {
			@ApiResponse
	})
	public List<TipoCursoDTO> obterTipoCurso() {
		return service.obterTipoCurso();
	}

	@GetMapping(value = "/obterTipoDiaCalendario", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna a lista de tipos de dia do calendário", tags = {
			"ClassesAuxiliares"
	}, responses = {
			@ApiResponse
	})
	public List<TipoDiaCalendarioDTO> obterTipoDiaCalendario() {
		return service.obterTipoDiaCalendario();
	}

	@GetMapping(value = "/obterTipoRecursoAula", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna a lista de tipos de recurso de aula", tags = {
			"ClassesAuxiliares"
	}, responses = {
			@ApiResponse
	})
	public List<TipoRecursoAulaDTO> obterTipoRecursoAula() {
		return service.obterTipoRecursoAula();
	}

	@GetMapping(value = "/obterVinculoMatricula", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna a lista de vínculos de matrícula", tags = {
			"ClassesAuxiliares"
	}, responses = {
			@ApiResponse
	})
	public List<VinculoMatriculaDTO> obterVinculoMatricula() {
		return service.obterVinculoMatricula();
	}

	@GetMapping(value = "/obterIdioma", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna a lista de idiomas", tags = {
			"ClassesAuxiliares"
	}, responses = {
			@ApiResponse
	})
	public List<IdiomaDTO> obterIdiomas() {
		return service.obterIdiomas();
	}

	@GetMapping(value = "/obterPais", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna a lista de países", tags = {
			"ClassesAuxiliares"
	}, responses = {
			@ApiResponse
	})
	public List<PaisDTO> obterPaises() {
		return service.obterPaises();
	}

	@GetMapping(value = "/obterPais/{nome}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna a lista de países por nome", tags = {
			"ClassesAuxiliares"
	}, responses = {
			@ApiResponse
	})
	public List<PaisDTO> obterPaisesPorNome(@PathVariable String nome) {
		return service.obterPaisPorNome(nome);
	}

	@GetMapping(value = "/obterEstadoProvincia/{idPais}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna a lista de estados/províncias por país", tags = {
			"ClassesAuxiliares"
	}, responses = {
			@ApiResponse
	})
	public List<EstadoProvinciaDTO> obterEstadoProvinciaPorPais(
			@PathVariable Long idPais) {
		return service.obterEstadoProvinciaPorPais(idPais);
	}

	@GetMapping(value = "/obterEstadoProvincia/{idPais}/{nome}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna a lista de estados/províncias por país e nome", tags = {
			"ClassesAuxiliares"
	}, responses = {
			@ApiResponse
	})
	public List<EstadoProvinciaDTO> obterEstadoProvinciaPorPaisENome(
			@PathVariable Long idPais, @PathVariable String nome) {
		return service.obterEstadoProvinciaPorPaisENome(idPais, nome);
	}

	@GetMapping(value = "/obterCidade/{nome}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna a lista de cidades por nome", tags = {
			"ClassesAuxiliares"
	}, responses = {
			@ApiResponse
	})
	public List<CidadeDTO> obterCidadePorNome(@PathVariable String nome) {
		return service.obterCidadePorNome(nome);
	}

	@GetMapping(value = "/obterCidade/porEstado/{estado}", produces = MediaType.APPLICATION_JSON_VALUE)
	@Operation(summary = "Retorna a lista de cidades por estado", tags = {
			"ClassesAuxiliares"
	}, responses = {
			@ApiResponse
	})
	public List<CidadeDTO> obterCidadePorNome(@PathVariable Long estado) {
		return service.obterCidadePorEstadoProvincia(estado);
	}

}
