package br.com.java.entity;

import java.util.Objects;


public class Restaurante {

    private String nomeRestaurante;

    public String getNomeRestaurante() {
        return nomeRestaurante;
    }

    public void setNomeRestaurante(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) return false;
        Restaurante that = (Restaurante) o;
        return Objects.equals(nomeRestaurante, that.nomeRestaurante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeRestaurante);
    }
}
