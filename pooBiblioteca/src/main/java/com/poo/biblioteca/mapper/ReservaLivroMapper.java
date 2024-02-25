package com.poo.biblioteca.mapper;

import com.poo.biblioteca.dto.LivroDto;
import com.poo.biblioteca.dto.ReservaLivroDto;
import com.poo.biblioteca.model.Livro;
import com.poo.biblioteca.model.ReservaLivro;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservaLivroMapper {
    ReservaLivroMapper INSTANCE = Mappers.getMapper(ReservaLivroMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nomeLivro", target = "nomeLivro")
    @Mapping(source = "isbn", target = "isbn")
    @Mapping(source = "categoria", target = "categoria")
    @Mapping(source = "genero", target = "genero")
    @Mapping(source = "anoLancamento", target = "anoLancamento")
    @Mapping(source = "edicao", target = "edicao")
    @Mapping(source = "quantidade", target = "quantidade")
    @Mapping(source = "autores", target = "autores")
    Livro dtoParaEntidade(LivroDto livroDto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "nomeLivro", target = "nomeLivro")
    @Mapping(source = "isbn", target = "isbn")
    @Mapping(source = "categoria", target = "categoria")
    @Mapping(source = "genero", target = "genero")
    @Mapping(source = "anoLancamento", target = "anoLancamento")
    @Mapping(source = "edicao", target = "edicao")
    @Mapping(source = "quantidade", target = "quantidade")
    @Mapping(source = "autores", target = "autores")
    LivroDto entidadeParaDto(Livro livro);

    @Mapping(source = "livroReservado", target = "livro")
    ReservaLivro dtoParaEntidade(ReservaLivroDto reservaLivroDto);
    
    @Mapping(source = "livro", target = "livroReservado")
    ReservaLivroDto entidadeParaDto(ReservaLivro reservaLivro);
}


