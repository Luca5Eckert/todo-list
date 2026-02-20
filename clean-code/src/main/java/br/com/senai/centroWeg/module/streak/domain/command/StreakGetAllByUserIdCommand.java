package br.com.senai.centroWeg.module.streak.domain.command;

public record StreakGetAllByUserIdCommand(
        int userId
) {

    public static StreakGetAllByUserIdCommand of(int userId) {
        return new StreakGetAllByUserIdCommand(userId);
    }
}
