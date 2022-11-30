package com.projSotware.alugase.controller;

import com.projSotware.alugase.builder.ModelMapBuilder;
import com.projSotware.alugase.enums.Mensagem;
import com.projSotware.alugase.enums.TituloPagina;
import com.projSotware.alugase.factory.MensagensFactory;
import com.projSotware.alugase.model.Empresa;
import com.projSotware.alugase.model.Endereco;
import com.projSotware.alugase.service.EmpresaService;
import java.io.IOException;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
    private String cadastrar(@RequestParam String email, @RequestParam String senha, @RequestParam String nome, @RequestParam String razaoSocial, @RequestParam String cnpj, @RequestParam String cpf, @RequestParam MultipartFile fotoRepresentante, ModelMap model) throws IOException{
        var enderecos = new ArrayList<Endereco>();
        Empresa empresa = new Empresa(email, senha, nome, razaoSocial, cnpj, null, cpf, fotoRepresentante.getBytes());
        try{
            empresaService.cadastrarEmpresa(empresa);
        } catch (Exception e){
            return "error";
        }
        return "redirect:/login";
    }

}