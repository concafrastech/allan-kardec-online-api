package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;
import java.util.List;

import com.allankardeconline.util.validacao.ListaNaoVazia;

public class ListaConteudoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3469730052398569297L;

	
	@ListaNaoVazia(message = "{campo.litsa_conteudo.obrigatorio}")
	List<ConteudoDTO> conteudos;

	public ListaConteudoDTO() {

	}

	
}
