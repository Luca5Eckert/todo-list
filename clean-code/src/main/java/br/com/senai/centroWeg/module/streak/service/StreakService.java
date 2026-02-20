package br.com.senai.centroWeg.module.streak.service;

import br.com.senai.centroWeg.module.streak.repository.StreakRepository;

public class StreakService {

    private final StreakRepository streakRepository;

    public StreakService(StreakRepository streakRepository) {
        this.streakRepository = streakRepository;
    }

}
