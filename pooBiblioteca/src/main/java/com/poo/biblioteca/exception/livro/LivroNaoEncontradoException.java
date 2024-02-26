package com.poo.biblioteca.exception.livro;

public class LivroNaoEncontradoException extends Exception{
    public LivroNaoEncontradoException(String message){
        super("Livro não encontrado");
    }
}
