package com.poo.biblioteca.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "MULTA")
public class Multa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "VALOR")
    private double valor;

    @Column(name = "VALIDADE")
    private String validade;

    @OneToOne(mappedBy = "multa")
    private ReservaLivro reserva;

    public Multa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public ReservaLivro getReserva() {
        return reserva;
    }

    public void setReserva(ReservaLivro reserva) {
        this.reserva = reserva;
    }
}



