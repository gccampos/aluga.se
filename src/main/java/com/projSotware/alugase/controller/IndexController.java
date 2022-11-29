package com.projSotware.alugase.controller;

import com.projSotware.alugase.builder.ModelMapBuilder;
import com.projSotware.alugase.enums.Mensagem;
import com.projSotware.alugase.enums.TituloPagina;
import com.projSotware.alugase.factory.MensagensFactory;
import com.projSotware.alugase.service.LoginService;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/")
public class IndexController {
    
    @Autowired
    private LoginService loginService;

    @GetMapping(path = {"/", "/index"})
    public String index(ModelMap model) {
        ModelMapBuilder.setTitulo(TituloPagina.HOME.getTitulo(), model);
        return "index";
    }

    @GetMapping(path = {"/login"})
    public String login(ModelMap model){
        String titulo = TituloPagina.LOGIN.getTitulo();
        ModelMapBuilder.setTitulo(titulo, model);
        return "login";
    }

    @PostMapping(path = {"/login"})
    public String logar(ModelMap model, @RequestParam String cpf, @RequestParam String senha, HttpSession sessao){
        var locador = loginService.loginLocador(cpf, senha);
        var locatario = loginService.loginLocatario(cpf, senha);
        if(locador == null && locatario == null){
            var mensagem = MensagensFactory.setMensagemComTipoETexto("error", Mensagem.ERRO_LOGIN.getMensagem());
            ModelMapBuilder.setMensagem(mensagem, model);
            String titulo = TituloPagina.LOGIN.getTitulo();
            ModelMapBuilder.setTitulo(titulo, model);
            return "login";
        }
        if(locador == null){
            sessao.setAttribute("usuarioLogado", locatario);
        }
        else {
            sessao.setAttribute("usuarioLogado", locador);
        }
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(ModelMap model, HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
