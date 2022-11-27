package com.projSotware.alugase.service;

import com.projSotware.alugase.model.DadosBancarios;
import com.projSotware.alugase.model.Endereco;
import com.projSotware.alugase.model.Locador;
import com.projSotware.alugase.repository.LocadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocadorService {
    @Autowired
    private LocadorRepository locadorRepository;

    public Locador buscarPorId(long id){
        return locadorRepository.findById(id);
    }

    public Locador buscarPorCpf(String cpf){
        return locadorRepository.findByCpf(cpf);
    }

    public void cadastrarLocador(String nome, String email, String cpf, String telefone, Endereco endereco, DadosBancarios dadosBancarios){
        var enderecos = new ArrayList<Endereco>();
        enderecos.add(endereco);
        Locador locador = new Locador(nome, email, cpf, telefone, enderecos, null);
        locadorRepository.save(locador);
    }

    public List<Locador> todosLocadores(){
        return locadorRepository.findAll();
    }


}
