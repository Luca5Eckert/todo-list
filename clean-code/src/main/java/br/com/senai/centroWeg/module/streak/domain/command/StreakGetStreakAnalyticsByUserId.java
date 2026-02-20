package br.com.senai.centroWeg.module.streak.domain.command;

public record StreakGetStreakAnalyticsByUserId(
        int userId
) {

    public static StreakGetStreakAnalyticsByUserId of(int userId) {
        return new StreakGetStreakAnalyticsByUserId(userId);
    }

}
