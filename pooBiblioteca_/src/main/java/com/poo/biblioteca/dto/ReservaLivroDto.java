package com.poo.biblioteca.dto;

import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class ReservaLivroDto {

    private String id;

    @NotNull(message = "Livro Reservado é obrigatório")
    private LivroDto livroReservado;

    @NotNull(message = "Data de Reserva é obrigatória")
    private String dataReserva;

    @NotNull(message = "Data de Devolução é obrigatória")
    private String dataDevolucao;

    @NotNull(message = "Usuário é obrigatório")
    private UsuarioDto usuario;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LivroDto getLivroReservado() {
        return livroReservado;
    }

    public void setLivroReservado(LivroDto livroReservado) {
        this.livroReservado = livroReservado;
    }

    public String getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(String dataReserva) {
        this.dataReserva = dataReserva;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public UsuarioDto getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDto usuario) {
        this.usuario = usuario;
    }
}
