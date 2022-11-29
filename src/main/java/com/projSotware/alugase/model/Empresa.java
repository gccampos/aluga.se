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
public class Empresa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String senha;
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    @OneToOne
    private DadosBancarios dadosBancarios;
    private String cpfRepresentante;
    @Lob
    private byte[] fotoRGRepresentante;



}
