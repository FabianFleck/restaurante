package br.com.java.entity;

import java.util.Objects;


public class Profissional {

    private String nomeProfissional;

    public String getNomeProfissional() {
        return nomeProfissional;
    }

    public void setNomeProfissional(String nomeProfissional) {
        this.nomeProfissional = nomeProfissional;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) return false;
        Profissional that = (Profissional) o;
        return Objects.equals(nomeProfissional, that.nomeProfissional);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeProfissional);
    }
}
