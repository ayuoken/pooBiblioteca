package com.poo.biblioteca.dto;

public class MultaDto {

    private Long id;
    private double valor;
    private String validade;
    private Long reservaId;

    public MultaDto() {
    }

    public MultaDto(Long id, double valor, String validade, Long reservaId) {
        this.id = id;
        this.valor = valor;
        this.validade = validade;
        this.reservaId = reservaId;
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

    public Long getReservaId() {
        return reservaId;
    }

    public void setReservaId(Long reservaId) {
        this.reservaId = reservaId;
    }

    @Override
    public String toString() {
        return "MultaDto{" +
                "id=" + id +
                ", valor=" + valor +
                ", validade='" + validade + '\'' +
                ", reservaId=" + reservaId +
                '}';
    }
}

