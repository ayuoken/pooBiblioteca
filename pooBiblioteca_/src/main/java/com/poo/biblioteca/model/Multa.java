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

    @Column(name = "PAGO")
    private boolean pago;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private StatusMulta status;

    public enum StatusMulta {
        PENDENTE,
        PAGA,
        CANCELADA
    }

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
    public boolean isPago() {
        return pago;
    }
    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public StatusMulta getStatus() {
        return status;
    }

    public void setStatus(StatusMulta status) {
        this.status = status;
    }
}



