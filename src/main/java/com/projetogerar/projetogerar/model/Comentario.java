package com.projetogerar.projetogerar.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String autora;
    private String texto;
    private int nota;

    @ManyToOne
    @JsonBackReference
    private Indicacao indicacao;
}
