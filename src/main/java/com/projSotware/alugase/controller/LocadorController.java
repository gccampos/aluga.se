package com.projSotware.alugase.controller;

import com.projSotware.alugase.enums.Mensagem;
import com.projSotware.alugase.model.Endereco;
import com.projSotware.alugase.model.Locador;
import com.projSotware.alugase.service.LocadorService;
import com.projSotware.alugase.builder.ModelMapBuilder;
import com.projSotware.alugase.enums.TituloPagina;
import com.projSotware.alugase.factory.MensagensFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping(path = "/locador")
public class LocadorController {

    @Autowired
    LocadorService locadorService;

    @GetMapping(value = "/cadastro")
    private String cadastro(ModelMap model){
        ModelMapBuilder.setTitulo(TituloPagina.CADASTRO_LOCADOR.getTitulo(), model);
        return "cadastroLocador";
    }

    @PostMapping(value = "/cadastrar")
    private String cadastrar(@RequestParam String nome, @RequestParam String email, @RequestParam String senha,@RequestParam String cpf,@RequestParam String telefone, ModelMap model){
        var enderecos = new ArrayList<Endereco>();
        Locador locador = new Locador(nome, senha,email, cpf, telefone, enderecos, null);
        try{
            locadorService.cadastrarLocador(locador);
        } catch (Exception e){
            return "error";
        }
        var mensagemSucesso = MensagensFactory.setMensagemComTipoETexto("success", Mensagem.SUCESSO_CADASTRO_LOCADOR.getMensagem());
        ModelMapBuilder.setMensagem(mensagemSucesso, model);
        ModelMapBuilder.setTitulo("Login", model);
        return "login";
    }

}
