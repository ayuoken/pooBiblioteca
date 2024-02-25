package com.poo.biblioteca.service;

import com.poo.biblioteca.model.Multa;
import com.poo.biblioteca.repository.MultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class MultaService {

    private final MultaRepository multaRepository;

    @Autowired
    public MultaService(MultaRepository multaRepository) {
        this.multaRepository = multaRepository;
    }

    public Multa criarMulta(Multa multa) {
        return multaRepository.save(multa);
    }

    public Multa atualizarMulta(Multa multa) {
        return multaRepository.save(multa);
    }

    public void excluirMulta(Long id) {
        if (!multaRepository.existsById(id)) {
            throw new EntityNotFoundException("Multa não encontrada com ID: " + id);
        }
        multaRepository.deleteById(id);
    }

    public Optional<Multa> buscarMultaPorId(Long id) {
        return multaRepository.findById(id);
    }

    public List<Multa> listarMultas() {
        return multaRepository.findAll();
    }
}
