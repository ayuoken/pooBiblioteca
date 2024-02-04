package com.poo.biblioteca.service;

import com.poo.biblioteca.model.Usuario;
import com.poo.biblioteca.repository.UsuarioRepository;
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
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;

    }

    @Transactional(rollbackFor = Throwable.class)
    public Usuario criarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Page<Usuario> findAll(Usuario filter, Pageable pageable){
        return usuarioRepository.findAll(createExample(filter), pageable);
    }

    private Example<Usuario> createExample(Usuario filter){
        ExampleMatcher caseInsensitiveExampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase();
        return Example.of(filter, caseInsensitiveExampleMatcher);
    }
    @Transactional(rollbackFor = Throwable.class)
    public void deleteById(Long id) {

        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> findById(Long id){
        return usuarioRepository.findById(id);
    }

    @Transactional(rollbackFor = Throwable.class)
    public Usuario saveUpdate(Usuario usuario){

        if(!usuarioRepository.existsById(usuario.getId())){
            throw  new EntityNotFoundException("Usuário : " + usuario.getId());
        }
        return criarUsuario(usuario);
    }

}