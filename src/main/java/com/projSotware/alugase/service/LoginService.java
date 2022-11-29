package com.projSotware.alugase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projSotware.alugase.model.Empresa;
import com.projSotware.alugase.model.Locador;
import com.projSotware.alugase.model.Locatario;

@Service
public class LoginService {
    @Autowired
    private LocatarioService locatarioService;
    @Autowired
    private EmpresaService empresaService;
    @Autowired
    private LocadorService locadorService;

    public Locador loginLocador(String cpf, String senha){
        var locador = locadorService.buscarPorCpf(cpf);
        if(locador == null ||  !locador.getSenha().equals(senha)){
            return null;
        }
        return locador;
    }

    public Locatario loginLocatario(String cpf, String senha){
        var locatario = locatarioService.buscarPorCpf(cpf);
        if(locatario == null || !locatario.getSenha().equals(senha)){
            return null;
        }
        return locatario;
    }

    public Empresa loginEmpresa(String cnpj, String senha){
        var empresa = empresaService.buscarPorCnpj(cnpj);
        if(empresa == null ||  !empresa.getSenha().equals(senha)){
            return null;
        }
        return empresa;
    }

}