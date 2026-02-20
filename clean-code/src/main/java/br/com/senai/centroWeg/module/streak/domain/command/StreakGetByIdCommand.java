package br.com.senai.centroWeg.module.streak.domain.command;

public record StreakGetByIdCommand(
        int streakId
) {

    public static StreakGetByIdCommand of(int streakId) {
        return new StreakGetByIdCommand(streakId);
    }
}
