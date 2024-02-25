package com.poo.biblioteca.entidade;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.poo.biblioteca.model.Livro;
import com.poo.biblioteca.repository.LivroRepository;

@SpringBootTest
public class LivroTest {
	@Autowired
	private LivroRepository livroRepository;
	
	@Test
	public void cadastrarTest() {
		long qtde = livroRepository.count();
		List<String> autores = new ArrayList<>();
		autores.add("Luana");
		Livro livro = new Livro("Go Back", "8912", "Literatura", "Drama", "2024", "1", "2",autores);
		livroRepository.save(livro);
		long qtd2 = livroRepository.count();
		assertEquals(qtde+1, qtd2);
	}
	
	@Test
	public void deletarTest() {
		long qtde = livroRepository.count();
		Long id = (long) 352;
		livroRepository.deleteById(id);
		long qtd2 = livroRepository.count();
		assertEquals(qtde-1, qtd2);
	}
}
