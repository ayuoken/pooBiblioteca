package com.poo.biblioteca.service;

import java.util.Optional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.poo.biblioteca.model.ReservaLivro;
import com.poo.biblioteca.repository.ReservaLivroRepository;
import com.poo.biblioteca.model.Multa;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;



@Service
public class ReservaLivroService {

    private final ReservaLivroRepository reservaLivroRepository;
    private final MultaService multaService;

    @Autowired
    public ReservaLivroService(MultaService multaService, ReservaLivroRepository reservaLivroRepository) {
        this.multaService = multaService;
        this.reservaLivroRepository = reservaLivroRepository;
    }

    @Transactional
    public ReservaLivro criarReserva(ReservaLivro reservaLivro) {
        return reservaLivroRepository.save(reservaLivro);
    }
    @Transactional
    public ReservaLivro reservarLivro(ReservaLivro reservaLivro) {
        return reservaLivroRepository.save(reservaLivro);
    }

    @Transactional(readOnly = true)
    public ReservaLivro buscarReservaPorId(Long id) {
        Optional<ReservaLivro> reservaOptional = reservaLivroRepository.findById(id);
        return reservaOptional.orElseThrow(() -> new EntityNotFoundException("Reserva de livro não encontrada com ID: " + id));
    }
    @Transactional
    public List<ReservaLivro> listarReservasPorUsuario(Long usuarioId) {
        return reservaLivroRepository.findByUsuarioId(usuarioId);
    }


    @Transactional
    public ReservaLivro atualizarReserva(Long idReserva, ReservaLivro reservaAtualizada) {
        ReservaLivro reservaExistente = reservaLivroRepository.findById(idReserva)
                .orElseThrow(() -> new EntityNotFoundException("Reserva de livro não encontrada com ID: " + idReserva));

        reservaExistente.setDataReservada(reservaAtualizada.getDataReservada());
        reservaExistente.setDataDevolucao(reservaAtualizada.getDataDevolucao());
        reservaExistente.setUsuario(reservaAtualizada.getUsuario());
        reservaExistente.setMulta(reservaAtualizada.getMulta());

        return reservaLivroRepository.save(reservaExistente);
    }


    @Transactional
    public void excluirReserva(Long id) {
        if (!reservaLivroRepository.existsById(id)) {
            throw new EntityNotFoundException("Reserva de Livro não encontrada com ID:" + id );
        }
        reservaLivroRepository.deleteById(id);
    }
    public void verificarReservasVencidas() {
        List<ReservaLivro> reservasVencidas = reservaLivroRepository.findReservasVencidas();

        for (ReservaLivro reserva : reservasVencidas) {
            if (reserva.getMulta() == null) {
                Multa multa = criarMultaAutomaticamente(reserva);
                multaService.criarMulta(multa);
            }
        }
    }

    private Multa criarMultaAutomaticamente(ReservaLivro reserva) {

        double valorMulta = calcularValorMulta(reserva);
        LocalDate dataValidade = LocalDate.now().plusDays(7);

        Multa multa = new Multa();
        multa.setValor(valorMulta);
        multa.setValidade(dataValidade.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        multa.setReserva(reserva);

        return multa;
    }

    private double calcularValorMulta(ReservaLivro reserva) {

        return 5.0;
    }

}

