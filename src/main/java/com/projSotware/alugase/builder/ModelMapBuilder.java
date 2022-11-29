package com.projSotware.alugase.builder;

import com.projSotware.alugase.model.Categoria;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.HashMap;

public class ModelMapBuilder {
    public static void setTitulo(String titulo, ModelMap model) {
        model.addAttribute("titulo", titulo);
    }

    public static void setMensagem(HashMap<String, String> mensagens, ModelMap model) {
        model.addAttribute("messages", mensagens);
    }
    public static void setListaCategorias(ArrayList<Categoria> listaCategorias, ModelMap model) {
        model.addAttribute("categorias", listaCategorias);
    }


}