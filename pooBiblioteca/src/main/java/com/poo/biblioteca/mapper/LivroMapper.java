package com.poo.biblioteca.mapper;

import com.poo.biblioteca.dto.LivroDto;
import com.poo.biblioteca.model.Livro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LivroMapper {
    LivroMapper INSTANCE = Mappers.getMapper(LivroMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nomeLivro", target = "nomeLivro")
    @Mapping(source = "isbn", target = "isbn")
    Livro dtoParaEntidade(LivroDto livroDto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nomeLivro", target = "nomeLivro")
    @Mapping(source = "isbn", target = "isbn")
    LivroDto entidadeParaDto(Livro livro);
}
