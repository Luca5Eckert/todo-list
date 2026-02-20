package br.com.senai.centroWeg.module.streak.domain.service;

import br.com.senai.centroWeg.module.streak.domain.command.StreakGetByIdCommand;
import br.com.senai.centroWeg.module.streak.domain.exception.StreakException;
import br.com.senai.centroWeg.module.streak.domain.model.Streak;
import br.com.senai.centroWeg.module.streak.domain.repository.StreakRepository;

public class StreakService {

    private final StreakRepository streakRepository;

    public StreakService(StreakRepository streakRepository) {
        this.streakRepository = streakRepository;
    }

    public Streak getById(StreakGetByIdCommand command) {
        return streakRepository.findById(command.streakId())
                .orElseThrow(() -> new StreakException("Streak not found"));
    }

}
