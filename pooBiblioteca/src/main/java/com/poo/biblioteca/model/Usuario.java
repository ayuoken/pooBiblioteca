package com.poo.biblioteca.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="TB_USUARIO")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_USUARIO",nullable = false)
    private Long id;

    @Column(name = "NOME",nullable = false)
    private String nome;

    @Column(name = "ENDERECO",nullable = false)
    private String endereco;

    @Column(name = "NUMERO_PARA_CONTATO",nullable = false)
    private String numeroContato;

    @Column(name = "EMAIL",nullable = false)
    private String email;

    @Column(name = "LOGIN",nullable = false)
    private String login;

    @Column(name = "SENHA",nullable = false)
    private String senha;

}
