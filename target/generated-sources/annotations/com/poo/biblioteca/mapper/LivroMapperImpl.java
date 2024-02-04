package com.poo.biblioteca.mapper;

import com.poo.biblioteca.dto.LivroDto;
import com.poo.biblioteca.model.Livro;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-03T23:48:27-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
public class LivroMapperImpl implements LivroMapper {

    @Override
    public Livro dtoParaEntidade(LivroDto livroDto) {
        if ( livroDto == null ) {
            return null;
        }

        Livro livro = new Livro();

        livro.setId( livroDto.getId() );
        livro.setNomeLivro( livroDto.getNome() );
        livro.setIsbn( livroDto.getIsbn() );

        return livro;
    }

    @Override
    public LivroDto entidadeParaDto(Livro livro) {
        if ( livro == null ) {
            return null;
        }

        LivroDto livroDto = new LivroDto();

        livroDto.setId( livro.getId() );
        livroDto.setNome( livro.getNomeLivro() );
        livroDto.setIsbn( livro.getIsbn() );

        return livroDto;
    }
}
