package controller;

import builder.ModelMapBuilder;
import enums.TituloPagina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = {"/"})
public class MainController {

    @Autowired
    ModelMapBuilder modelMapBuilder;

    @GetMapping(path = {"/"})
    public String index(ModelMap model) {
        ModelMapBuilder.setTitulo(TituloPagina.HOME.getTitulo(), model);
        return "index";
    }

}
