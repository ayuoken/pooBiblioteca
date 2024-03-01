package com.poo.biblioteca.repository;

import com.poo.biblioteca.model.ReservaLivro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReservaLivroRepository extends JpaRepository<ReservaLivro, Long> {

    List<ReservaLivro> findByUsuarioId(Long usuarioId);
    List<ReservaLivro> findByLivroReservadoId(Long livroId);
    @Query("SELECT r FROM ReservaLivro r WHERE r.dataDevolucao IS NULL")
    List<ReservaLivro> findReservasPendentes();
    @Query("SELECT r FROM ReservaLivro r WHERE r.dataDevolucao < CURRENT_DATE")
    List<ReservaLivro> findReservasVencidas();

}
