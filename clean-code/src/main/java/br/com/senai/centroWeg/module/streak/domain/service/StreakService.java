package br.com.senai.centroWeg.module.streak.domain.service;

import br.com.senai.centroWeg.module.streak.domain.command.StreakGetAllByUserIdCommand;
import br.com.senai.centroWeg.module.streak.domain.command.StreakGetByIdCommand;
import br.com.senai.centroWeg.module.streak.domain.command.StreakGetByUserIdCommand;
import br.com.senai.centroWeg.module.streak.domain.exception.StreakException;
import br.com.senai.centroWeg.module.streak.domain.model.Streak;
import br.com.senai.centroWeg.module.streak.domain.repository.StreakRepository;

import java.util.List;

public class StreakService {

    private final StreakRepository streakRepository;

    public StreakService(StreakRepository streakRepository) {
        this.streakRepository = streakRepository;
    }

    public Streak getById(StreakGetByIdCommand command) {
        return streakRepository.findById(command.streakId())
                .orElseThrow(() -> new StreakException("Streak not found"));
    }

    public Streak getByActiveByUserId(StreakGetByUserIdCommand command) {
        return streakRepository.findActiveByUserId(command.userId())
                .orElseThrow(() -> new StreakException("Active streak not found for user"));
    }

    public List<Streak> getAllStreakByUserId(StreakGetAllByUserIdCommand command) {
        return streakRepository.findALlByUserId(command.userId());
    }
}
