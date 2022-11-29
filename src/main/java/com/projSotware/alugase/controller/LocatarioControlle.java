package com.projSotware.alugase.controller;

import com.projSotware.alugase.builder.ModelMapBuilder;
import com.projSotware.alugase.enums.TituloPagina;
import com.projSotware.alugase.service.LocatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    


}
