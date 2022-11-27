package com.projSotware.alugase.enums;

public enum TituloPagina {
    HOME("Página Inicial"),
    CADASTRO_LOCADOR("Cadastro Locador");
    private final String titulo;

    TituloPagina(String tituloPagina) {
        this.titulo = tituloPagina;
    }

    public String getTitulo() {
        return titulo;
    }
}
