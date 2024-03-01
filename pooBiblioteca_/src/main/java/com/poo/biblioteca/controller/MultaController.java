package com.poo.biblioteca.controller;

import com.poo.biblioteca.model.Multa;
import com.poo.biblioteca.service.MultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/multas")
public class MultaController {

    private final MultaService multaService;

    @Autowired
    public MultaController(MultaService multaService) {
        this.multaService = multaService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Multa criarMulta(@RequestBody Multa multa) {
        return multaService.criarMulta(multa);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Multa> atualizarMulta(@PathVariable Long id, @RequestBody Multa multa) {
        try {
            Multa multaAtualizada = multaService.atualizarMulta(multa);
            return ResponseEntity.ok(multaAtualizada);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> excluirMulta(@PathVariable Long id) {
        try {
            multaService.excluirMulta(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Multa> buscarMultaPorId(@PathVariable Long id) {
        try {
            Multa multa = multaService.buscarMultaPorId(id)
                    .orElseThrow(() -> new EntityNotFoundException("Multa não encontrada com ID: " + id));
            return ResponseEntity.ok(multa);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Multa> listarMultas() {
        return multaService.listarMultas();
    }
}
