package br.com.senai.centroWeg.module.streak.domain.command;

import br.com.senai.centroWeg.module.streak.application.dto.StreakGetByIdRequest;
import br.com.senai.centroWeg.module.streak.domain.model.Streak;

public record StreakGetByIdCommand(
        int streakId
) {

    public static StreakGetByIdCommand of(int streakId) {
        return new StreakGetByIdCommand(streakId);
    }
}
