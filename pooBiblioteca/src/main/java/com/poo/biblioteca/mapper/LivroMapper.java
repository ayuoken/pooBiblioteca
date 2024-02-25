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
	}
