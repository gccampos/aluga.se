package com.projSotware.alugase.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Locatario extends Usuario implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    public Locatario(String nome, String senha, String email, String cpf, String telefone, ArrayList<Endereco> enderecos){
        super(nome, senha, email, cpf, telefone, enderecos);
    }



}
