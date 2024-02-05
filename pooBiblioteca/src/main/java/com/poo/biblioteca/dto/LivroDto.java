package com.poo.biblioteca.dto;

import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class LivroDto {

    private Long id;

    @NotNull(message = "Nome Obrigatório!")
    private String nomeLivro;

    @NotNull(message = "ISBN Obrigatório!")
    private String isbn;

}
