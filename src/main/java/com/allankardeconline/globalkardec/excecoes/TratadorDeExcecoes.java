package com.allankardeconline.globalkardec.excecoes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class TratadorDeExcecoes {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<RetornoErro> tratarTodasExcecoes(Exception ex,
			WebRequest request) {

		RetornoErro retornoErro = new RetornoErro(ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<>(retornoErro,
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(RecursoNaoEncontradoException.class)
	public final ResponseEntity<RetornoErro> tratarExcecaoRequisicaoErrada(
			Exception ex, WebRequest request) {

		RetornoErro retornoErro = new RetornoErro(ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<>(retornoErro, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(CadastroDependenteException.class)
	public final ResponseEntity<RetornoErro> tratarExcecaoCadastroDependente(
			Exception ex, WebRequest request) {

		RetornoErro retornoErro = new RetornoErro(ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<>(retornoErro,
				HttpStatus.PRECONDITION_FAILED);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public final ResponseEntity<RetornoErro> tratarExcecaoIntegridadeDeDados(
			Exception ex, WebRequest request) {

		RetornoErro retornoErro = new RetornoErro(ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<>(retornoErro,
				HttpStatus.PRECONDITION_FAILED);
	}

	@ExceptionHandler(InformacaoObrigatoriaException.class)
	public final ResponseEntity<RetornoErro> tratarExcecaoInformatacaoObrigatoria(
			Exception ex, WebRequest request) {

		RetornoErro retornoErro = new RetornoErro(ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<>(retornoErro,
				HttpStatus.PRECONDITION_FAILED);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity<RetornoErro> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException ex, WebRequest request) {

		List<String> errors = ex.getBindingResult().getAllErrors().stream()
				.map(erro -> erro.getDefaultMessage())
				.collect(Collectors.toList());

		RetornoErro retornoErro = new RetornoErro("Erro de validação", errors);

		return new ResponseEntity<>(retornoErro, HttpStatus.BAD_REQUEST);
	}

}
