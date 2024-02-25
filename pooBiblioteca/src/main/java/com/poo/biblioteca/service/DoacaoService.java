package com.poo.biblioteca.service;

import org.springframework.stereotype.Service;

import com.poo.biblioteca.model.Doacao;
import com.poo.biblioteca.repository.LivroRepository;

@Service
public class DoacaoService {
	
	private LivroRepository livroRepository;
	
	public Doacao receberDoacao(Doacao doacao) {
		doacao.setSituacao(true);
		livroRepository.save(doacao.getLivro());
		return doacao;
	}
}
