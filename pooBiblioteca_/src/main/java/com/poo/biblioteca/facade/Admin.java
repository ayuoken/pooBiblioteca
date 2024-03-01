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
import com.poo.biblioteca.model.Usuario;
import com.poo.biblioteca.repository.LivroRepository;
import com.poo.biblioteca.repository.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class Admin {

    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional(rollbackFor = Throwable.class)
    public Livro criarLivro(Livro livro){ return livroRepository.save(livro);}


    @Transactional(rollbackFor = Throwable.class)
    public void deleteById(Long id){
        livroRepository.deleteById(id);
    }


    @Transactional(rollbackFor = Throwable.class)
    public Livro saveUpdate(Livro livro){
        if(!livroRepository.existsById(livro.getId())){
            throw new EntityNotFoundException("Livro: " + livro.getId());
        }
        return criarLivro(livro);
    }

    public Page<Usuario> findAll(Usuario filter, Pageable pageable){
        return usuarioRepository.findAll(createExample(filter), pageable);
    }

    private Example<Usuario> createExample(Usuario filter){
        ExampleMatcher caseInsensitiveExampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase();
        return Example.of(filter, caseInsensitiveExampleMatcher);
    }

    @Transactional(rollbackFor = Throwable.class)
    public void deleteUserById(Long id) {

        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> findById(Long id){
        return usuarioRepository.findById(id);
    }
}
