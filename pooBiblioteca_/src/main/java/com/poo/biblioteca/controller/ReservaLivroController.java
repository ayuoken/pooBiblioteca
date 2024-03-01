package com.poo.biblioteca.controller;

import com.poo.biblioteca.model.ReservaLivro;
import com.poo.biblioteca.service.ReservaLivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reserva-livro")
public class ReservaLivroController {

    @Autowired
    private ReservaLivroService reservaLivroService;



    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> reservarLivro(@RequestBody ReservaLivro reservaLivro) {
        try {
            ReservaLivro reservaCriada = reservaLivroService.reservarLivro(reservaLivro);
            return ResponseEntity.status(HttpStatus.CREATED).body(reservaCriada);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao reservar livro: " + e.getMessage());
        }
    }
}

