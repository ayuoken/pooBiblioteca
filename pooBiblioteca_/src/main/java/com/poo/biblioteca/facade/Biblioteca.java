package com.poo.biblioteca.facade;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poo.biblioteca.model.Livro;
import com.poo.biblioteca.repository.LivroRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class Biblioteca {
    @Autowired
    private LivroRepository livroRepository;

    public Page<Livro> findAll(Livro filter, Pageable pageable){
        return livroRepository.findAll(createExample(filter), pageable);
    }

    private Example<Livro> createExample(Livro filter){
        ExampleMatcher caseInsensitiveExampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase();
        return Example.of(filter, caseInsensitiveExampleMatcher);
    }

    public Optional<Livro> findByIsbn(String isbn) { return livroRepository.findByIsbn(isbn);}

    public Optional<Livro> findById(Long id) { return livroRepository.findById(id);}

    public Optional<Livro> findByNomeLivro(String nomeLivro) {return livroRepository.findByNomeLivro(nomeLivro);}

}
