package com.projSotware.alugase.controller;

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

import java.util.HashMap;

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
    private String cadastrar(@RequestParam String nome, @RequestParam String email, @RequestParam String cpf,@RequestParam String telefone, ModelMap model){
        try{
            locadorService.cadastrarLocador(nome, email, cpf, telefone, null, null);
        } catch (Exception e){
            return "error";
        }
        HashMap<String, String> mensagemSucesso = MensagensFactory.getMensagemComTipoETexto("success", MensagensFactory.getSucessoCadastroLocador());
        ModelMapBuilder.setMensagem(mensagemSucesso, model);
        ModelMapBuilder.setTitulo("Login", model);
        return "login";
    }

}
