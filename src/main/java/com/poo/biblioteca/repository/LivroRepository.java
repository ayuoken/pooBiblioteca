package com.poo.biblioteca.repository;

import com.poo.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    Optional<Livro> findByIsbn(Long isbn);
}
