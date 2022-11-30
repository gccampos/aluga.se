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

    public Empresa(String email, String senha, String nomeFantasia, String razaoSocial, String cnpj, DadosBancarios dadosBancarios, String cpfRepresentante, byte[] fotoRGRepresentante) {
        this.email = email;
        this.senha = senha;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.dadosBancarios = dadosBancarios;
        this.cpfRepresentante = cpfRepresentante;
        this.fotoRGRepresentante = fotoRGRepresentante;
    }

    

}
