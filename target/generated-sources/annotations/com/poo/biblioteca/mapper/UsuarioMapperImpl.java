package com.poo.biblioteca.mapper;

import com.poo.biblioteca.dto.UsuarioDto;
import com.poo.biblioteca.model.Usuario;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-03T23:48:27-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public Usuario dtoParaEntidade(UsuarioDto usuarioDto) {
        if ( usuarioDto == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId( usuarioDto.getId() );
        usuario.setNome( usuarioDto.getNome() );
        usuario.setEndereco( usuarioDto.getEndereco() );
        usuario.setNumeroContato( usuarioDto.getNumeroContato() );
        usuario.setEmail( usuarioDto.getEmail() );
        usuario.setLogin( usuarioDto.getLogin() );
        usuario.setSenha( usuarioDto.getSenha() );

        return usuario;
    }

    @Override
    public UsuarioDto entidadeParaDto(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDto usuarioDto = new UsuarioDto();

        usuarioDto.setId( usuario.getId() );
        usuarioDto.setNome( usuario.getNome() );
        usuarioDto.setEndereco( usuario.getEndereco() );
        usuarioDto.setNumeroContato( usuario.getNumeroContato() );
        usuarioDto.setEmail( usuario.getEmail() );
        usuarioDto.setLogin( usuario.getLogin() );
        usuarioDto.setSenha( usuario.getSenha() );

        return usuarioDto;
    }
}
