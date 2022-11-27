package com.projSotware.alugase.controller;

import com.projSotware.alugase.builder.ModelMapBuilder;
import com.projSotware.alugase.enums.TituloPagina;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class IndexController {

    @GetMapping(path = {"/", "/index"})
    public String index(ModelMap model) {
        ModelMapBuilder.setTitulo(TituloPagina.HOME.getTitulo(), model);
        return "index";
    }

}
