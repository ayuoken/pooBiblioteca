package com.poo.biblioteca.mapper;

import com.poo.biblioteca.dto.UsuarioDto;
import com.poo.biblioteca.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "endereco", target = "endereco")
    @Mapping(source = "numeroContato", target = "numeroContato")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "login", target = "login")
    @Mapping(source = "senha", target = "senha")
    Usuario dtoParaEntidade(UsuarioDto usuarioDto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nome", target = "nome")
    @Mapping(source = "endereco", target = "endereco")
    @Mapping(source = "numeroContato", target = "numeroContato")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "login", target = "login")
    @Mapping(source = "senha", target = "senha")
    UsuarioDto entidadeParaDto(Usuario usuario);

}