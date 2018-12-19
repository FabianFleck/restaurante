package br.com.java.validator;

import br.com.java.controller.DBMemory;
import br.com.java.entity.Profissional;
import br.com.java.entity.Voto;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.List;

public class ProfissionalVotoValidator {
    public static boolean validate(Profissional profissional, LocalDate dataVotacao) {
        List<Voto> votos = DBMemory.getInstance().getVotos().get(dataVotacao);

        return CollectionUtils.isEmpty(votos)
                || votos.stream()
                .map(Voto::getProfissional)
                .noneMatch(nome -> nome.getNomeProfissional()
                        .equals(profissional.getNomeProfissional().toUpperCase()));
    }
}
