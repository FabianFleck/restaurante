package br.com.java.controller;

import br.com.java.creator.VotoCreator;
import br.com.java.entity.Voto;
import br.com.java.validator.HoraResultadoValidator;
import br.com.java.validator.ProfissionalVotoValidator;
import br.com.java.validator.RestauranteGanhadorValidator;
import br.com.java.validator.RestauranteValidoValidator;

import java.util.*;


public class VotacaoController {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Digite seu nome: ");
            String nameProfissional = scanner.next();
            System.out.print("Digite o restaurante: ");
            String nameRestaurante = scanner.next();

            VotoCreator.votar(VotoCreator.createVoto(nameProfissional, nameRestaurante));
        }
    }
}
