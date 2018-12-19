package br.com.java.validator;

import br.com.java.controller.DBMemory;
import br.com.java.entity.Restaurante;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Objects;

public class RestauranteValidoValidator {
    public static boolean validate(Restaurante restaurante, LocalDate dataVotacao) {
        return DBMemory.getInstance().getRestauranteGanhador().entrySet().stream()
                .filter(restauranteGanhador -> Objects.equals(getWeekNumber(dataVotacao), getWeek(restauranteGanhador.getKey())))
                .noneMatch(restauranteGanhador -> restauranteGanhador.getValue().equals(restaurante));
    }
    private static int getWeekNumber(LocalDate dataVotacao) {
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        return dataVotacao.get(weekFields.weekOfWeekBasedYear());
    }

    private static int getWeek(LocalDate date) {
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        return date.get(weekFields.weekOfWeekBasedYear());
    }
}
