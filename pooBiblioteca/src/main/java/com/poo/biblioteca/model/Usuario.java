package com.poo.biblioteca.model;

import jakarta.persistence.*;

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
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumeroContato() {
		return numeroContato;
	}

	public void setNumeroContato(String numeroContato) {
		this.numeroContato = numeroContato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


}
