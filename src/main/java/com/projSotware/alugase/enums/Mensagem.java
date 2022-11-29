package com.projSotware.alugase.enums;

public enum Mensagem {
    SUCESSO_CADASTRO_LOCADOR("Locador Cadastrado com sucesso"),
    SUCESSO_CADASTRO_PRODUTO("Produto Cadastrado com sucesso"),
    SUCESSO_CADASTRO_CATEGORIA("Categoria Cadastrada com sucesso"),
    SUCESSO_CADASTRO_EMPRESA("Empresa Cadastrada com sucesso"),
    SUCESSO_CADASTRO_LOCATARIO("Locatario Cadastrado com sucesso");
    Mensagem(String Mensagem) {
        this.mensagem = Mensagem;
    }
    private final String mensagem;
    public String getMensagem() {
        return mensagem;
    }
}
