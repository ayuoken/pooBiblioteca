package com.poo.biblioteca.model;

import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "RESERVA_LIVRO")

public class ReservaLivro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MULTA_ID")
    private Multa multa;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_LIVRO")
    private Livro livroReservado;

    @Column(name = "DATA_RESERVADA")
    private LocalDate dataReservada;

    @Column(name = "DATA_DEVOLUCAO")
    private LocalDate dataDevolucao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;



    public ReservaLivro() {
    }

    public ReservaLivro(Long id, Livro livroReservado, LocalDate dataReservada, LocalDate dataDevolucao, Usuario usuario) {
        this.id = id;
        this.livroReservado = livroReservado;
        this.dataReservada = dataReservada;
        this.dataDevolucao = dataDevolucao;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Livro getLivroReservado() {
        return livroReservado;
    }

    public void setLivroReservado(Livro livroReservado) {
        this.livroReservado = livroReservado;
    }

    public LocalDate getDataReservada() {
        return dataReservada;
    }

    public void setDataReservada(LocalDate dataReservada) {
        this.dataReservada = dataReservada;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Multa getMulta() {
        return multa;
    }
    public void setMulta(Multa multa) {
        this.multa = multa;
    }
}
