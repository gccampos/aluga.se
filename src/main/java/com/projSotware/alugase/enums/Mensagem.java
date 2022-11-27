package com.projSotware.alugase.enums;

public enum Mensagem {
    SUCESSO_CADASTRO_LOCADOR("Locador Cadastrado com sucesso"),
    SUCESSO_CADASTRO_PRODUTO("Produto Cadastrado com sucesso");
    Mensagem(String Mensagem) {
        this.mensagem = Mensagem;
    }
    private final String mensagem;
    public String getMensagem() {
        return mensagem;
    }
}
