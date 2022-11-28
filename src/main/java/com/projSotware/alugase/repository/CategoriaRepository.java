package com.projSotware.alugase.repository;


import com.projSotware.alugase.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Categoria findById(long id);
    Categoria findByNome(String nome);
    List<Categoria> findAll();



}
