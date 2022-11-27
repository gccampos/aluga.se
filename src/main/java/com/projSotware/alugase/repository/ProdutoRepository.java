package com.projSotware.alugase.repository;

import com.projSotware.alugase.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Produto findById(long id);
    Produto findByNome(String nome);
    List<Produto> findAll();
}
