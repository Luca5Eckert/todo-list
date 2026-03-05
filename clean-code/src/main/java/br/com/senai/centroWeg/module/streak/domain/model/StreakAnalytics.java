package br.com.senai.centroWeg.module.streak.domain.model;

public record StreakAnalytics(
        Double averageDaysStreak,
        Streak currentStreak,
        Streak longestStreak
) {}