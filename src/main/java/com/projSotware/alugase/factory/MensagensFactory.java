package com.projSotware.alugase.factory;

import lombok.Getter;

import java.util.HashMap;

@Getter
public class MensagensFactory {

    private static final String SUCESSO_CADASTRO_LOCADOR = "Locador Cadastrado com sucesso";

    public static String getSucessoCadastroLocador() {
        return SUCESSO_CADASTRO_LOCADOR;
    }

    public static HashMap<String, String> getMensagemComTipoETexto(String tipo, String texto) {
        var mensagem = new HashMap<String, String>();
        mensagem.put("tipo", tipo);
        mensagem.put("texto", texto);
        return mensagem;
    }


}