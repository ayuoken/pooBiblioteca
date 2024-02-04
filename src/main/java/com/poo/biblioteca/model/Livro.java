package com.poo.biblioteca.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="TB_LIVRO")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_LIVRO",nullable = false)
    private Long id;

    @Column(name = "NOME_LIVRO",nullable = false)
    private String nomeLivro;

    @Column(name = "ISBN", nullable = false)
    private Long isbn;

}
