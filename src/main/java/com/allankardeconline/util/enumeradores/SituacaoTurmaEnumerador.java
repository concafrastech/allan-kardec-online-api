package com.allankardeconline.util.enumeradores;

public enum SituacaoTurmaEnumerador {

	ABERTA(0, "Aberta"), CONCLUIDA(1, "Concluída");

	int codigo;
	String nome;

	SituacaoTurmaEnumerador(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
