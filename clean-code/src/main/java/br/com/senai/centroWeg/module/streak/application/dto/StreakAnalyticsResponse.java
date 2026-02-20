package br.com.senai.centroWeg.module.streak.application.dto;

public record StreakAnalyticsResponse(
        double averageDaysStreak,
        StreakResponse currentStreak,
        StreakResponse longestStreakResponse
) {
}
