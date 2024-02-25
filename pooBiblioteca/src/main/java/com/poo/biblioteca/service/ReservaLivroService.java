package com.poo.biblioteca.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.poo.biblioteca.model.ReservaLivro;
import com.poo.biblioteca.repository.ReservaLivroRepository;
import jakarta.persistence.EntityNotFoundException;



@Service
public class ReservaLivroService {

    private final ReservaLivroRepository reservaLivroRepository;

    @Autowired
    public ReservaLivroService(ReservaLivroRepository reservaLivroRepository) {
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
    public ReservaLivro atualizarReserva(Long id, ReservaLivro reservaLivroAtualizada) {
        ReservaLivro reservaLivro = buscarReservaPorId(id);
        reservaLivro.setLivroReservado(reservaLivroAtualizada.getLivroReservado());
        reservaLivro.setDataReservada(reservaLivroAtualizada.getDataReservada());
        reservaLivro.setDataDevolucao(reservaLivroAtualizada.getDataDevolucao());
        reservaLivro.setUsuario(reservaLivroAtualizada.getUsuario());
        return reservaLivroRepository.save(reservaLivro);
    }

    @Transactional
    public void excluirReserva(Long id) {
    	if (!reservaLivroRepository.existsById(id)) {
    		throw new EntityNotFoundException("Reserva de Livro não encontrada com ID:" + id );
    	}
        reservaLivroRepository.deleteById(id);
    }
}
