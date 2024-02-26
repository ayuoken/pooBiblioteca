package com.poo.biblioteca.facade;

import com.poo.biblioteca.model.ReservaLivro;
import com.poo.biblioteca.service.ReservaLivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Reservas {

    private final ReservaLivroService reservaLivroService;

    @Autowired
    public Reservas(ReservaLivroService reservaLivroService) {
        this.reservaLivroService = reservaLivroService;
    }

    public ResponseEntity<?> reservarLivro(ReservaLivro reservaLivro) {
        try {
            ReservaLivro reservaCriada = reservaLivroService.reservarLivro(reservaLivro);
            return ResponseEntity.status(HttpStatus.CREATED).body(reservaCriada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao reservar livro: " + e.getMessage());
        }
    }

    public ResponseEntity<List<ReservaLivro>> listarReservasUsuario(Long idUsuario) {
        List<ReservaLivro> reservasUsuario = reservaLivroService.listarReservasPorUsuario(idUsuario);
        if (reservasUsuario.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(reservasUsuario);
        }
    }
    
}
