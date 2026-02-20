package br.com.senai.centroWeg.module.streak.domain.command;

public record StreakGetByUserIdCommand(
        int userId
) {
    public static StreakGetByUserIdCommand of(int userId) {
        return new StreakGetByUserIdCommand(userId);
    }
}
