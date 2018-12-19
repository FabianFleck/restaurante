package br.com.java.validator;

import java.time.LocalTime;

/**
 * Validator responsável por validar a hora do resultado.
 * @author Fabian Fleck
 * @since 17/12/2018
 */
public class HoraResultadoValidator {
    public static boolean validate() {
        LocalTime time = LocalTime.of(12,00,00);
        LocalTime timeNow = LocalTime.now();
        return timeNow.isAfter(time);
    }
}
