package com.poo.biblioteca.dto;

import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class UsuarioDto {
    private Long id;
    @NotNull(message = "Nome Obrigatório!")
    private String nome;
    @NotNull(message = "Endereço Obrigatório!")
    private String endereco;
    @NotNull(message = "Número para contato Obrigatório!")
    private String numeroContato;
    @NotNull(message = "E-mail Obrigatório!")
    private String email;
    @NotNull(message = "Login Obrigatório!")
    private String login;
    @NotNull(message = "Senha Obrigatória!")
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
