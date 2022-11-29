package com.projSotware.alugase.repository;

import com.projSotware.alugase.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    Empresa findById(long id);
    Empresa findByNome(String nome);
    List<Empresa> findAll();

}
