package com.projSotware.alugase.controller;

import com.projSotware.alugase.builder.ModelMapBuilder;
import com.projSotware.alugase.enums.TituloPagina;
import com.projSotware.alugase.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/empresa")
public class EmpresaController {
    @Autowired
    EmpresaService empresaService;
    String titulo = TituloPagina.CADASTRO_EMPRESA.getTitulo();

    @GetMapping("/cadastro")
    public String cadastro(ModelMap model){
        ModelMapBuilder.setTitulo(titulo, model);
        return "cadastroEmpresa";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(ModelMap model){
        return "cadastroEmpresa";
    }

}
