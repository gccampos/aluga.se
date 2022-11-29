package com.projSotware.alugase.service;

import com.projSotware.alugase.model.Produto;
import com.projSotware.alugase.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    public Produto buscarPorId(long id){
        return produtoRepository.findById(id);
    }

    public Produto buscarPorNome(String nome){
        return produtoRepository.findByNome(nome);
    }

    public ArrayList<Produto> todosProdutos(){
        return (ArrayList<Produto>) produtoRepository.findAll();
    }

    public void cadastrarProduto(Produto produto){
         produtoRepository.save(produto);
    }
}
