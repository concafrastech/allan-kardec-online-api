package com.allankardeconline.globalkardec.dto;

import java.io.Serializable;

public class ArquivoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8123901439095922297L;
	private String nomeDoArquivo;
	private String nomeDoArquivoUri;
	private String tipoArquivo;
	private long tamanho;
	
	

	public ArquivoDTO() {
	
	}

	public String getNomeDoArquivo() {
		return nomeDoArquivo;
	}

	public void setNomeDoArquivo(String nomeDoArquivo) {
		this.nomeDoArquivo = nomeDoArquivo;
	}

	public String getNomeDoArquivoUri() {
		return nomeDoArquivoUri;
	}

	public void setNomeDoArquivoUri(String nomeDoArquivoUri) {
		this.nomeDoArquivoUri = nomeDoArquivoUri;
	}

	public String getTipoArquivo() {
		return tipoArquivo;
	}

	public void setTipoArquivo(String tipoArquivo) {
		this.tipoArquivo = tipoArquivo;
	}

	public long getTamanho() {
		return tamanho;
	}

	public void setTamanho(long tamanho) {
		this.tamanho = tamanho;
	}

}
