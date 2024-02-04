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

}
