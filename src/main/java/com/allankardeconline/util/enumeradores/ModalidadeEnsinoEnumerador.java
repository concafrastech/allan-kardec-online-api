package com.allankardeconline.util.enumeradores;

public enum ModalidadeEnsinoEnumerador {

    PRESENCIAL(0, "Presencial"), SINCRONO(1, "EAD Síncrono"),
    ASSINCRONO(2, "EAD Assíncrono"), ARQUIVADO(3, "Arquivado");

    int codigo;
    String nome;

    ModalidadeEnsinoEnumerador(int codigo, String nome) {
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
