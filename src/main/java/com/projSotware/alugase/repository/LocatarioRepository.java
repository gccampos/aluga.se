package com.projSotware.alugase.repository;

import com.projSotware.alugase.model.Locatario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocatarioRepository extends JpaRepository<Locatario, Long> {

    Locatario findById(long id);
    Locatario findByNome(String nome);
    List<Locatario> findAll();

}
