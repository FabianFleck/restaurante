package br.com.java.validator;

import br.com.java.controller.DBMemory;
import br.com.java.entity.Restaurante;
import br.com.java.entity.Voto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class RestauranteGanhadorValidator {

    public static String validate(Voto voto) {
        Restaurante restaurante = verifyRestauranteGanhador(getVotosOrDefault(voto));

        if (Objects.nonNull(restaurante)) {
            DBMemory.getInstance().getRestauranteGanhador().put(voto.getDataVotacao(), restaurante);
            return "Ganhador: " + restaurante.getNomeRestaurante();
        } else {
            return "Sem votos na data para calcular";
        }
    }

    private static Restaurante verifyRestauranteGanhador(List<Voto> votos) {
        if (votos.isEmpty()) {
            return null;
        } else {
            return votos.stream().collect(Collectors.groupingBy(
                    Voto::getRestaurante, Collectors.counting())).entrySet()
                    .stream().max(Map.Entry.comparingByValue()).get().getKey();
        }
    }
    private static List<Voto> getVotosOrDefault(Voto voto) {
        return DBMemory.getInstance().getVotos().getOrDefault(voto.getDataVotacao(), new ArrayList<>());
    }
}
