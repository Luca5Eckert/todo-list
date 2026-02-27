package br.com.senai.centroWeg.module.streak.domain.query;

public record GetStreakAnalyticsQuery(int userId) {
    public static GetStreakAnalyticsQuery of(int userId) {

        return new GetStreakAnalyticsQuery(userId);
    }
}



