package com.allankardeconline.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.allankardeconline.globalkardec.excecoes.RecursoNaoEncontradoException;
import com.allankardeconline.globalkardec.repository.CentroEspiritaRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CentroEspiritaFilter extends OncePerRequestFilter {

	private final String TENANT_HEADER = "x-centro-id";

	@Value("${ceoak.codigo-padrao}")
	private String ceaokPadrao;

	private final CentroEspiritaRepository centroEspiritaRepository;

	public CentroEspiritaFilter(
			CentroEspiritaRepository centroEspiritaRepository) {
		this.centroEspiritaRepository = centroEspiritaRepository;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException,
			RecursoNaoEncontradoException {

//
//
//		var tenantHeader = request.getHeader(TENANT_HEADER) == null
//				? getCeaokPadrao()
//				: request.getHeader(TENANT_HEADER);
//
//		if (tenantHeader == null) {
//			response.getWriter()
//					.write("'x-centro-id' nao encontrado no cabecalho");
//			response.setStatus(HttpStatus.NOT_FOUND.value());
//
//			return;
//
//		}
//
//		var centroEspirita = centroEspiritaRepository
//				.findByUuid(UUID.fromString(tenantHeader)).orElse(null);
//
//		if (centroEspirita == null) {
//			response.getWriter()
//					.write("Centro espirita nao identificado: " + tenantHeader);
//			response.setStatus(HttpStatus.NOT_FOUND.value());
//		}
//
//		TenantContext
//				.setCentroEspiritaAtual(centroEspirita.getUuid().toString());
//		TenantContext.setCentroEspiritaAtualID(centroEspirita.getId());
		chain.doFilter(request, response);
	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) {
		return request.getRequestURI().startsWith("/webjars/")
				|| request.getRequestURI().startsWith("/css/")
				|| request.getRequestURI().startsWith("/js/")
				|| request.getRequestURI().startsWith("/login")
				|| request.getRequestURI().startsWith("/swagger-ui")
				|| request.getRequestURI().startsWith("/doc")
				|| request.getRequestURI().endsWith(".ico");
	}

	public String getCeaokPadrao() {
		return ceaokPadrao;
	}

	public void setCeaokPadrao(String ceaokPadrao) {
		this.ceaokPadrao = ceaokPadrao;
	}

}
