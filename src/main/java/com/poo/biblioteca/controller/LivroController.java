package com.poo.biblioteca.controller;

import com.poo.biblioteca.service.LivroService;
import com.poo.biblioteca.dto.LivroDto;
import com.poo.biblioteca.dto.UsuarioDto;
import com.poo.biblioteca.mapper.LivroMapper;
import com.poo.biblioteca.model.Livro;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping(path = "/livro")
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService){
        this.livroService = livroService;
    }

    @GetMapping(path = "/livrosPaginados", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Page<LivroDto> buscarLivros(
            LivroDto filter,
            @PageableDefault
            @SortDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        Page<Livro> pageLivro = this.livroService.findAll(LivroMapper.INSTANCE.dtoParaEntidade(filter), pageable);

        Page<LivroDto> pageLivroDto = pageLivro.map(LivroMapper.INSTANCE::entidadeParaDto);

        return pageLivroDto;
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public LivroDto buscarLivroPorId(@PathVariable Long id){
        var livro = livroService.findById(id).orElseThrow(() -> new EntityNotFoundException("Livro: "+ id));
        return LivroMapper.INSTANCE.entidadeParaDto(livro);
    }

    @GetMapping(path = "/isbn/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
    public LivroDto buscarLivroPorIsbn(@PathVariable Long isbn){
        var livro = livroService.findByIsbn(isbn).orElseThrow(() -> new EntityNotFoundException("Livro: "+isbn));
        return LivroMapper.INSTANCE.entidadeParaDto(livro);
    }

    @PostMapping(path = "/salvarLivro")
    public LivroDto salvarLivro(@RequestBody LivroDto livroDto){
        Livro livro = LivroMapper.INSTANCE.dtoParaEntidade(livroDto);

        Livro livroCriado = livroService.criarLivro(livro);

        return LivroMapper.INSTANCE.entidadeParaDto(livroCriado);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public LivroDto alterarLivro(@RequestBody @Valid LivroDto livroDto){
        Livro livro = LivroMapper.INSTANCE.dtoParaEntidade(livroDto);
        Livro livroCriado = livroService.saveUpdate(livro);
        return LivroMapper.INSTANCE.entidadeParaDto(livroCriado);
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deletarLivro(@PathVariable Long id){
        livroService.deleteById(id);
    }

}