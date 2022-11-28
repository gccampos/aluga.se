package com.projSotware.alugase.service;

import com.projSotware.alugase.model.Categoria;
import com.projSotware.alugase.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria buscarPorId(long id){
        return categoriaRepository.findById(id);
    }

    public Categoria buscarPorNome(String nome){
        return categoriaRepository.findByNome(nome);
    }

    public void cadastrarCategoria(Categoria categoria){
        categoriaRepository.save(categoria);
    }

}
