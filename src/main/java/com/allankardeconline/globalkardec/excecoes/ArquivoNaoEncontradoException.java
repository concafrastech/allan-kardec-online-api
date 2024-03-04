package com.allankardeconline.globalkardec.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ArquivoNaoEncontradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6212460738463809593L;

	public ArquivoNaoEncontradoException(String ex) {
		super(ex);
	}

	public ArquivoNaoEncontradoException(String ex, Throwable cause) {
		super(ex, cause);
	}
}
