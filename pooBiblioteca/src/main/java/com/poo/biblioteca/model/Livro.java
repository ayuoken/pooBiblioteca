package com.poo.biblioteca.model;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

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

    @Column(name = "ISBN_LIVRO", nullable = false)
    private String isbn;

    @Column(name = "CATEGORIA_LIVRO", nullable = false)
    private String categoria;

    @Column(name = "GENERO_LIVRO", nullable = false)
    private String genero;

    @Column(name = "ANOLANCAMENTO_LIVRO", nullable = false)
    private String anoLancamento;

    @Column(name = "EDICAO_LIVRO", nullable = false)
    private String edicao;

    @Column(name = "QUANTIDADE_LIVRO", nullable = false)
    private String quantidade;

    @Column(name="AUTORES_LIVRO", nullable = false)
    private List<String> autores;
    
    public Livro() {
    	
    }

    public Livro(String nomeLivro, String isbn, String categoria, String genero, String anoLancamento,
			String edicao, String quantidade, List<String> autores) {
		//this.id = id;
		this.nomeLivro = nomeLivro;
		this.isbn = isbn;
		this.categoria = categoria;
		this.genero = genero;
		this.anoLancamento = anoLancamento;
		this.edicao = edicao;
		this.quantidade = quantidade;
		this.autores = autores;
	}

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
