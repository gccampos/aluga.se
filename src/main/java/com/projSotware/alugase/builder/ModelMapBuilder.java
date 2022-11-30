package com.projSotware.alugase.builder;

import com.projSotware.alugase.model.*;
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
    public static void setListaEmpresas(ArrayList<Empresa> listaEmpresas, ModelMap model) {
        model.addAttribute("empresas", listaEmpresas);
    }  public static void setListaLocadores(ArrayList<Locador> listaLocadores, ModelMap model) {
        model.addAttribute("locadores", listaLocadores);
    }
    public static void setListaLocatarios(ArrayList<Locatario> listaLocatarios, ModelMap model) {
        model.addAttribute("locatarios", listaLocatarios);
    }  public static void setListaProdutos(ArrayList<Produto> listaProduto, ModelMap model) {
        model.addAttribute("produtos", listaProduto);
    }



}