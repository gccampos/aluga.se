package com.projSotware.alugase.service;

import com.projSotware.alugase.model.Locatario;
import com.projSotware.alugase.repository.LocadorRepository;
import com.projSotware.alugase.repository.LocatarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Service
public class LocatarioService {
    @Autowired
    LocatarioRepository locatarioRepository;

    public Locatario buscarPorId(long id){
        return locatarioRepository.findById(id);
    }

    public Locatario buscarPorCpf(String cpf){
        return locatarioRepository.findByCpf(cpf);
    }

    public void cadastrarLocatario(Locatario locatario){
        locatarioRepository.save(locatario);
    }

    public ArrayList<Locatario> todosLocatarios(){
        return (ArrayList<Locatario>) locatarioRepository.findAll();
    }

}
