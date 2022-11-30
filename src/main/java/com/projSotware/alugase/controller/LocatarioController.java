package com.projSotware.alugase.controller;

import com.projSotware.alugase.builder.ModelMapBuilder;
import com.projSotware.alugase.enums.Mensagem;
import com.projSotware.alugase.enums.TituloPagina;
import com.projSotware.alugase.factory.MensagensFactory;
import com.projSotware.alugase.model.Locatario;
import com.projSotware.alugase.service.LocatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/locatario")
public class LocatarioController {
    @Autowired
    LocatarioService locatarioService;
    String titulo = TituloPagina.CADASTRO_LOCATARIO.getTitulo();

    @GetMapping(value = "/cadastro")
    private String cadastro(ModelMap model){
        ModelMapBuilder.setTitulo(titulo, model);
        return "cadastroLocatario";
    }

    @PostMapping(value = "/cadastrar")
    private String cadastrar(ModelMap model, @RequestParam String nome, @RequestParam String senha, @RequestParam String email, @RequestParam String cpf, @RequestParam String telefone){
        var locatario = new Locatario(nome, senha, email, cpf, telefone, null);
        locatarioService.cadastrarLocatario(locatario);
        var mensagem = MensagensFactory.setMensagemComTipoETexto("success",Mensagem.SUCESSO_CADASTRO_LOCATARIO.getMensagem());
        ModelMapBuilder.setMensagem(mensagem, model);
        ModelMapBuilder.setTitulo(titulo, model);
        return "login";
    }

    @GetMapping(value = "/locatarios")
    public String locatarios(ModelMap model){
        ModelMapBuilder.setListaLocatarios(locatarioService.todosLocatarios(), model);
        ModelMapBuilder.setTitulo(TituloPagina.LISTA_LOCATARIOS.getTitulo(), model);
        return "listaLocatarios";
    }


}
