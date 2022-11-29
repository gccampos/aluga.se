package com.projSotware.alugase.controller;

import com.projSotware.alugase.builder.ModelMapBuilder;
import com.projSotware.alugase.enums.Mensagem;
import com.projSotware.alugase.enums.TituloPagina;
import com.projSotware.alugase.factory.MensagensFactory;
import com.projSotware.alugase.model.Categoria;
import com.projSotware.alugase.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.beans.XMLEncoder;

@Controller
@RequestMapping(path = "/categoria")
public class CategoriaController {

    @Autowired
    CategoriaService categoriaService;
    private String titulo = TituloPagina.CADASTRO_CATEGORIA.getTitulo();

    @GetMapping(value = "/cadastro")
    public String cadastro(ModelMap model){
        ModelMapBuilder.setTitulo(titulo, model);
        return "cadastroCategoria";
    }
    
    @PostMapping(value = "/cadastrar")
    public String cadastrar(ModelMap model, @RequestParam String nome){
        var categoria = new Categoria(nome);
        categoriaService.cadastrarCategoria(categoria);
        var mensagem = MensagensFactory.getMensagemComTipoETexto("success", Mensagem.SUCESSO_CADASTRO_CATEGORIA.getMensagem());
        ModelMapBuilder.setMensagem(mensagem, model);
        return "cadastroCategoria";

    }

}
