package com.allankardeconline.globalkardec.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class DuplicidadeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6212460738463809593L;

	public DuplicidadeException(String ex) {
		super(ex);
	}

}
