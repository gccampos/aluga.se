package com.projSotware.alugase.factory;

import lombok.Getter;

import java.util.HashMap;

@Getter
public class MensagensFactory {

    public static HashMap<String, String> setMensagemComTipoETexto(String tipo, String texto) {
        var mensagem = new HashMap<String, String>();
        mensagem.put("tipo", tipo);
        mensagem.put("texto", texto);
        return mensagem;
    }


}