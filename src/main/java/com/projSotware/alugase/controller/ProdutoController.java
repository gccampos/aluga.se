package com.projSotware.alugase.controller;

import com.projSotware.alugase.builder.ModelMapBuilder;
import com.projSotware.alugase.enums.Mensagem;
import com.projSotware.alugase.enums.TituloPagina;
import com.projSotware.alugase.factory.MensagensFactory;
import com.projSotware.alugase.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/produto")
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;
    private String titulo = TituloPagina.CADASTRO_PRODUTO.getTitulo();

    @GetMapping(value = "/cadastro")
    public String cadastro(ModelMap model){
        ModelMapBuilder.setTitulo(titulo, model);
        return "cadastroProduto";
    }

    @PostMapping(value = "/cadastrar")
    public String cadastrar(ModelMap model){
        var mensagemSucesso = MensagensFactory.setMensagemComTipoETexto("success", Mensagem.SUCESSO_CADASTRO_PRODUTO.getMensagem());
        ModelMapBuilder.setTitulo(TituloPagina.CADASTRO_PRODUTO.getTitulo(), model);
        ModelMapBuilder.setMensagem(mensagemSucesso, model);
        return "cadastroProduto";
    }
}
