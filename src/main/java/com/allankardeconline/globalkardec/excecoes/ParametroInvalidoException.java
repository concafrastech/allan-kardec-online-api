package com.allankardeconline.globalkardec.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class ParametroInvalidoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6212460738463809593L;

	public ParametroInvalidoException(String ex) {
		super(ex);
	}

}
