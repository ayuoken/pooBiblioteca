package com.example.demo.entidade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.poo.biblioteca.facade.Admin;
import com.poo.biblioteca.model.Livro;
import com.poo.biblioteca.repository.LivroRepository;

@SpringBootTest
public class LivroTest {
    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private Admin fachadaAdmin;

    //Teste de unidade [TC0?] (Luana)
    @Test
    public void validarGetAutores() {
        List<String> autores = new ArrayList<>();
        autores.add("Luana");
        Livro livro = new Livro("Go Back", "8912", "Literatura", "Drama", "2024", "1", "2",autores);
        assertEquals(livro.getAutores(), autores);
    }

    //Teste de integração [TC0?] (Luana)
    @Test
    public void atualizarTest() {


        List<String> autores = new ArrayList<>();
        autores.add("Luana");
        Livro livro = new Livro("Go Back", "8912", "Literatura", "Drama", "2024", "1", "2",autores);
        fachadaAdmin.criarLivro(livro);

        String genero = "Ficção científica";
        livro.setGenero(genero);
        fachadaAdmin.saveUpdate(livro);

        assertEquals(genero, livro.getGenero());
    }


}
