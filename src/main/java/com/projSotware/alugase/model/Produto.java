package com.projSotware.alugase.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    @OneToOne
    private Categoria categoria;
    @Lob
    private byte[] foto;
    private float valorDiaria;
    @OneToOne
    private Locador locador;

    public Produto(String nome, Categoria categoria, byte[] foto, float valorDiaria, Locador locador){
        this.nome = nome;
        this.categoria = categoria;
        this.foto = foto;
        this.valorDiaria = valorDiaria;
        this.locador = locador;
    }
}
