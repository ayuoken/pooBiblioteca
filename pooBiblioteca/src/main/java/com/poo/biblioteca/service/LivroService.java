package com.poo.biblioteca.service;

import com.poo.biblioteca.model.Livro;
import com.poo.biblioteca.repository.LivroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository livroRepository;
    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Transactional(rollbackFor = Throwable.class)
    public Livro criarLivro(Livro livro){ return livroRepository.save(livro);}

    public Page<Livro> findAll(Livro filter, Pageable pageable){
        return livroRepository.findAll(createExample(filter), pageable);
    }

    private Example<Livro> createExample(Livro filter){
        ExampleMatcher caseInsensitiveExampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase();
        return Example.of(filter, caseInsensitiveExampleMatcher);
    }

    @Transactional(rollbackFor = Throwable.class)
    public void deleteById(Long id){
        livroRepository.deleteById(id);
    }

    public Optional<Livro> findByIsbn(String isbn) { return livroRepository.findByIsbn(isbn);}

    public Optional<Livro> findById(Long id) { return livroRepository.findById(id);}

    @Transactional(rollbackFor = Throwable.class)
    public Livro saveUpdate(Livro livro){
        if(!livroRepository.existsById(livro.getId())){
            throw new EntityNotFoundException("Livro: " + livro.getId());
        }
        return criarLivro(livro);
    }
}