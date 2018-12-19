package br.com.java.controller;

import br.com.java.entity.Restaurante;
import br.com.java.entity.Voto;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class DBMemory {

    private static DBMemory insance;

    private Map<LocalDate, Restaurante> restauranteGanhador;
    private Map<LocalDate, List<Voto>> votos;

    public static synchronized DBMemory getInstance() {
        if(Objects.isNull(insance)) {
            insance = new DBMemory();
            insance.setRestauranteGanhador(new HashMap<>());
            insance.setVotos(new HashMap<>());
        }

        return insance;
    }

    public Map<LocalDate, Restaurante> getRestauranteGanhador() {
        return restauranteGanhador;
    }

    private void setRestauranteGanhador(Map<LocalDate, Restaurante> restauranteGanhador) {
        this.restauranteGanhador = restauranteGanhador;
    }

    public Map<LocalDate, List<Voto>> getVotos() {
        return votos;
    }

    private void setVotos(Map<LocalDate, List<Voto>> votos) {
        this.votos = votos;
    }
}
