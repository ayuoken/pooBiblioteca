package com.example.demo.entidade;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.poo.biblioteca.model.Livro;
import com.poo.biblioteca.model.Multa;
import com.poo.biblioteca.model.ReservaLivro;
import com.poo.biblioteca.model.Usuario;
import com.poo.biblioteca.repository.LivroRepository;
import com.poo.biblioteca.repository.MultaRepository;
import com.poo.biblioteca.repository.ReservaLivroRepository;
import com.poo.biblioteca.repository.UsuarioRepository;

@SpringBootTest
public class ReservaTest {

    @Autowired
    private ReservaLivroRepository reservaLivroRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MultaRepository multaRepository;

    private Long idDoLivro;
    private Long idDoUsuario;
    private Long idDaMulta;

    @BeforeEach
    public void setUp() {
        List<String> autores = new ArrayList<>();
        autores.add("Luana");
        Livro livro = new Livro("Go Back", "8912", "Literatura", "Drama", "2024", "1", "2", autores);
        livroRepository.save(livro);
        idDoLivro = livro.getId();

        Usuario usuario = new Usuario();
        usuario.setNome("Nome do Usuário");
        usuario.setEndereco("Endereço do Usuário");
        usuario.setNumeroContato("123456789");
        usuario.setEmail("usuario@example.com");
        usuario.setLogin("usuario");
        usuario.setSenha("senha");
        usuarioRepository.save(usuario);
        idDoUsuario = usuario.getId();

        Multa multa = new Multa();
        multaRepository.save(multa);
        idDaMulta = multa.getId();
    }

    @Test
    public void testSalvarReservaLivro() {
        LocalDate dataReservada = LocalDate.now();
        LocalDate dataDevolucao = LocalDate.now().plusDays(7);

        ReservaLivro reservaLivro = new ReservaLivro();
        reservaLivro.setLivroReservado(livroRepository.findById(idDoLivro).orElse(null));
        reservaLivro.setUsuario(usuarioRepository.findById(idDoUsuario).orElse(null));
        reservaLivro.setMulta(multaRepository.findById(idDaMulta).orElse(null));
        reservaLivro.setDataReservada(dataReservada);
        reservaLivro.setDataDevolucao(dataDevolucao);

        reservaLivroRepository.save(reservaLivro);
        ReservaLivro reservaSalva = reservaLivroRepository.findById(reservaLivro.getId()).orElse(null);
        assertEquals(dataReservada, reservaSalva.getDataReservada());
        assertEquals(dataDevolucao, reservaSalva.getDataDevolucao());
    }
}
