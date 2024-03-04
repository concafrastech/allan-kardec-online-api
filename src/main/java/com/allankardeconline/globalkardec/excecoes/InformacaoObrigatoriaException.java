package com.allankardeconline.globalkardec.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InformacaoObrigatoriaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6212460738463809593L;

	public InformacaoObrigatoriaException(String ex) {
		super(ex);
	}

}
