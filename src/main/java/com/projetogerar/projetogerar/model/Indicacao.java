package com.projetogerar.projetogerar.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Indicacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private TipoIndicacao tipo;
    private String endereco;
    private String descricao;

    @Pattern(regexp = "\\d{11}", message = "O telefone deve conter exatamente 11 dígitos numéricos")
    private String telefone;

    private int numNotas;
    private int sumNotas;
}
