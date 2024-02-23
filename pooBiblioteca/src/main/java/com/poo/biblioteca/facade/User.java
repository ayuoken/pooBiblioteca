package com.poo.biblioteca.facade;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.poo.biblioteca.model.Usuario;
import com.poo.biblioteca.repository.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

public class User {
	
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Transactional(rollbackFor = Throwable.class)
    public Usuario criarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    

    

    @Transactional(rollbackFor = Throwable.class)
    public Usuario saveUpdate(Usuario usuario){

        if(!usuarioRepository.existsById(usuario.getId())){
            throw  new EntityNotFoundException("Usuário : " + usuario.getId());
        }
        return criarUsuario(usuario);
    }
}
