package com.projetogerar.projetogerar.model;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "indicacao", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Comentario> comentarios = new ArrayList<>();
}
