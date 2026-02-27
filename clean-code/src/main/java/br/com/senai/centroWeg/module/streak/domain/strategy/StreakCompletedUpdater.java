package br.com.senai.centroWeg.module.streak.domain.strategy;

import br.com.senai.centroWeg.module.streak.domain.model.Streak;
import br.com.senai.centroWeg.module.streak.domain.repository.StreakRepository;
import br.com.senai.centroWeg.module.todo.domain.port.StreakUpdater;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class StreakCompletedUpdater implements StreakUpdater {

    private final StreakRepository streakRepository;

    public StreakCompletedUpdater(StreakRepository streakRepository) {
        this.streakRepository = streakRepository;
    }

    @Override
    public void update(int userId) {
        var yesterday = LocalDate.now().minusDays(1);

        Streak currentStreak = streakRepository.findActiveByUserId(userId, yesterday)
                .orElseGet(() -> createNew(userId));

        currentStreak.increment();

        streakRepository.save(currentStreak);
    }

    private Streak createNew(int userId) {
        return Streak.builder()
                .userId(userId)
                .days(0)
                .start(LocalDate.now())
                .build();
    }

}
