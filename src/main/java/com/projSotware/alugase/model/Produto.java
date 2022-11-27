package com.projSotware.alugase.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto implements Serializable {

    @Id
    private Long id;

    private String nome;
    @OneToOne
    private Categoria categoria;
    @Lob
    private byte[] foto;
    private float valorDiaria;
    @OneToOne
    private Locador locador;
}
