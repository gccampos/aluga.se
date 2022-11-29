package com.projSotware.alugase.service;

import com.projSotware.alugase.model.Empresa;
import com.projSotware.alugase.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {
    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa buscarPorId(long id){
        return empresaRepository.findById(id);
    }

    public Empresa buscarPorNome(String nome){
        return empresaRepository.findByNome(nome);
    }




}
