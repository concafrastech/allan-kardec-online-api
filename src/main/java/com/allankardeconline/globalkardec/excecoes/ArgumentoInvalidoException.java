package com.allankardeconline.globalkardec.excecoes;

import org.springframework.core.MethodParameter;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

public class ArgumentoInvalidoException extends MethodArgumentNotValidException {

	public ArgumentoInvalidoException(MethodParameter parameter, BindingResult bindingResult) {
		super(parameter, bindingResult);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4521854152862860279L;

}
