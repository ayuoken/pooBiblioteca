package com.poo.biblioteca.repository;

import com.poo.biblioteca.model.Doacao;
import com.poo.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    Optional<Livro> findById(Long id);
    Optional<Livro> findByIsbn(String isbn);
    Optional<Livro> findByNomeLivro(String nomeLivro);


    Livro save(Livro livro);
}
