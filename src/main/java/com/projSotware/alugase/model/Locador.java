package com.projSotware.alugase.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Locador extends Usuario implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private DadosBancarios dadosBancarios;

    @Lob
    private byte[] fotoRG;

    public Locador(String nome, String email, String cpf, String telefone, ArrayList<Endereco> enderecos, DadosBancarios dadosBancarios) {
         super(nome, email, cpf, telefone, enderecos);
         this.dadosBancarios = dadosBancarios;
    }
}
