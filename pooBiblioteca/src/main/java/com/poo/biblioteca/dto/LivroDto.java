package com.poo.biblioteca.dto;

import java.util.List;

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

    @NotNull(message = "Categoria Obrigatório!")
    private String categoria;

    @NotNull(message = "Genero Obrigatório!")
    private String genero;

    @NotNull(message = "Ano de Lançamento Obrigatório!")
    private String anoLancamento;

    @NotNull(message = "Edicao Obrigatório!")
    private String edicao;

    @NotNull(message = "Quantidade Obrigatório!")
    private String quantidade;

    @NotNull(message = "Autores Obrigatório!")
    private List<String> autores;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public List<String> getAutores() {
        return autores;
    }

    public void setAutores(List<String> autores) {
        this.autores = autores;
    }
}
