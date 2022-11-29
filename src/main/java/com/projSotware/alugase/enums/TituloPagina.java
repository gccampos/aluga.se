package com.projSotware.alugase.enums;

public enum TituloPagina {

    HOME("Página Inicial"),
    LOGIN("Login"),
    CADASTRO_LOCADOR("Cadastro Locador"),
    CADASTRO_PRODUTO("Cadastro Produto"),
    CADASTRO_CATEGORIA("Cadastro Categoria"),
    CADASTRO_EMPRESA("Cadastro Empresa"),
    CADASTRO_LOCATARIO("Cadastro Locatário");
    TituloPagina(String tituloPagina) {
        this.titulo = tituloPagina;
    }
    private final String titulo;

    public String getTitulo() {
        return titulo;
    }
}
