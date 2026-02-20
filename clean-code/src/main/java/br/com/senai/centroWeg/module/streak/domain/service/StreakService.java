package br.com.senai.centroWeg.module.streak.domain.service;

import br.com.senai.centroWeg.module.streak.domain.command.StreakCreateCommand;
import br.com.senai.centroWeg.module.streak.domain.repository.StreakRepository;

public class StreakService {

    private final StreakRepository streakRepository;

    public StreakService(StreakRepository streakRepository) {
        this.streakRepository = streakRepository;
    }


    public void create(StreakCreateCommand command) {
    }

}
