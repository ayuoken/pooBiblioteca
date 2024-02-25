package com.poo.biblioteca.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poo.biblioteca.dto.LivroDto;
import com.poo.biblioteca.mapper.LivroMapper;
import com.poo.biblioteca.model.Doacao;
import com.poo.biblioteca.model.Livro;
import com.poo.biblioteca.service.DoacaoService;

@RestController
@RequestMapping(path = "/doacao")
public class DoacaoController {
	private final DoacaoService doacaoService;
	
	public DoacaoController(DoacaoService doacaoService) {
		this.doacaoService = doacaoService;
	}
	
	@PostMapping(path = "/receberDoacao")
    public Doacao aprovarDoacao(@RequestBody Doacao doacao) {
        //Livro livro = LivroMapper.INSTANCE.dtoParaEntidade(livroDto);

        Doacao doacaoAdicionadaAoAcervo = doacaoService.receberDoacao(doacao);
        return doacaoAdicionadaAoAcervo;

        //return LivroMapper.INSTANCE.entidadeParaDto(livroCriado);
    }
}
