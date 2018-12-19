package br.com.java.creator;

import br.com.java.controller.DBMemory;
import br.com.java.entity.Profissional;
import br.com.java.entity.Restaurante;
import br.com.java.entity.Voto;
import br.com.java.validator.HoraResultadoValidator;
import br.com.java.validator.ProfissionalVotoValidator;
import br.com.java.validator.RestauranteGanhadorValidator;
import br.com.java.validator.RestauranteValidoValidator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VotoCreator {

    public static void votar(Voto voto) {
        if (HoraResultadoValidator.validate()) {
            System.out.println(RestauranteGanhadorValidator.validate(voto));
        }
        else if (!ProfissionalVotoValidator.validate(voto.getProfissional(), voto.getDataVotacao())) {
            System.out.println("O profissional já votou!");
        } else if (!RestauranteValidoValidator.validate(voto.getRestaurante(), voto.getDataVotacao())) {
            System.out.println("O restaurante já foi eleito nesta semana!");
        } else {
            VotoCreator.cadastraVoto(voto);
        }
    }

    /**
     * Método responsável por cadastrar o voto do {@link Profissional}.
     *
     * @param voto Objeto referente ao voto do {@link Profissional}.
     */
    public static void cadastraVoto(Voto voto) {
        List<Voto> votos = getVotosOrDefault(voto);
        votos.add(voto);
        DBMemory.getInstance().getVotos().put(voto.getDataVotacao(), votos);
        System.out.println("Votação realizada!");
    }

    /**
     * Método responsável por criar um {@link Voto} conforme dados passados por parâmetro.
     *
     * @param nomeProfissional nome do profissional que está votando.
     * @param nomeRestaurante nome do restaurante que o profissional escolheu.
     * @return {@link Voto} voto após ser criado.
     */
    public static Voto createVoto(String nomeProfissional, String nomeRestaurante) {
        Profissional profissional = new Profissional();
        profissional.setNomeProfissional(nomeProfissional.toUpperCase());

        Restaurante restaurante = new Restaurante();
        restaurante.setNomeRestaurante(nomeRestaurante.toUpperCase());

        Voto voto = new Voto();
        voto.setProfissional(profissional);
        voto.setRestaurante(restaurante);
        voto.setDataVotacao(LocalDate.now());
        return voto;
    }

    /**
     * Método responsável por retornar uma lista de votos, conforma data de {@link Voto} passada por parâmetro.
     *
     * @param voto {@link Voto} voto.
     * @return Lista de {@link Voto}.
     */
    private static List<Voto> getVotosOrDefault(Voto voto) {
        return DBMemory.getInstance().getVotos().getOrDefault(voto.getDataVotacao(), new ArrayList<>());
    }
}
