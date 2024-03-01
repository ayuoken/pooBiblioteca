package com.poo.biblioteca.model;

public class Doacao {

    private Livro livro;
    private Usuario usuario;
    private boolean situacao = false;
    public Livro getLivro() {
        return livro;
    }


    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public boolean isSituacao() {
        return situacao;
    }
    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }



}
