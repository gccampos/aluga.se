package com.projSotware.alugase.enums;

public enum TituloPagina {

    HOME("Página Inicial"),
    CADASTRO_LOCADOR("Cadastro Locador"),
    CADASTRO_PRODUTO("Cadastro Produto");
    TituloPagina(String tituloPagina) {
        this.titulo = tituloPagina;
    }
    private final String titulo;

    public String getTitulo() {
        return titulo;
    }
}
