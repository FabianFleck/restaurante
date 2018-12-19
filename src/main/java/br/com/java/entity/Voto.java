package br.com.java.entity;

import java.time.LocalDate;


public class Voto {

    private Profissional profissional;

    private Restaurante restaurante;

    private LocalDate dataVotacao;

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public LocalDate getDataVotacao() {
        return dataVotacao;
    }

    public void setDataVotacao(LocalDate dataVotacao) {
        this.dataVotacao = dataVotacao;
    }
}
