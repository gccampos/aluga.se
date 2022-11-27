package com.projSotware.alugase.repository;

import com.projSotware.alugase.model.Locador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocadorRepository extends JpaRepository<Locador, Long> {

    Locador findById(long id);
    Locador findByCpf(String cpf);
    List<Locador> findAll();

}
