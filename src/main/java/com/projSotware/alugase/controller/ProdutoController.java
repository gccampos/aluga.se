package com.projSotware.alugase.controller;

import com.projSotware.alugase.builder.ModelMapBuilder;
import com.projSotware.alugase.enums.Mensagem;
import com.projSotware.alugase.enums.TituloPagina;
import com.projSotware.alugase.factory.MensagensFactory;
import com.projSotware.alugase.model.Locador;
import com.projSotware.alugase.model.Produto;
import com.projSotware.alugase.service.CategoriaService;
import com.projSotware.alugase.service.LocadorService;
import com.projSotware.alugase.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping(path = "/produto")
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;
    @Autowired
    CategoriaService categoriaService;
    @Autowired
    LocadorService locadorService;
    private String titulo = TituloPagina.CADASTRO_PRODUTO.getTitulo();

    @GetMapping(value = "/cadastro")
    public String cadastro(ModelMap model){
        ModelMapBuilder.setTitulo(titulo, model);
        ModelMapBuilder.setListaCategorias(categoriaService.todasCategorias(), model);
        return "cadastroProduto";
    }

    @PostMapping(value = "/cadastrar")
    public String cadastrar(ModelMap model, HttpSession sessao, @RequestParam String nome, @RequestParam String idCategoria, @RequestParam String valorDiaria, @RequestParam MultipartFile imagem){
        var categoria = categoriaService.buscarPorId(Long.parseLong(idCategoria));
//        Locador locador = locadorService.buscarPorId((Locador) sessao.getAttribute("usuarioLogado").getId());
        try {
            var produto = new Produto(nome, categoria, imagem.getBytes(),Float.parseFloat(valorDiaria), null);
            produtoService.cadastrarProduto(produto);
            var mensagemSucesso = MensagensFactory.setMensagemComTipoETexto("success", Mensagem.SUCESSO_CADASTRO_PRODUTO.getMensagem());
            ModelMapBuilder.setTitulo(TituloPagina.CADASTRO_PRODUTO.getTitulo(), model);
            ModelMapBuilder.setMensagem(mensagemSucesso, model);
            return "cadastroProduto";
        } catch (IOException e) {
            return "error";
        }
    }
    @GetMapping(value = "/produtos")
    public String produtos(ModelMap model){
        ModelMapBuilder.setListaProdutos(produtoService.todosProdutos(), model);
        ModelMapBuilder.setTitulo(TituloPagina.LISTA_PRODUTOS.getTitulo(), model);
        return "listaProdutos";
    }

}
