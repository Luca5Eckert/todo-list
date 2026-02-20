package br.com.senai.centroWeg.module.streak.domain.model;

public interface StreakAnalytics {

    double getAverageDaysStreak();
    Streak getCurrentStreak();
    Streak getLongestStreak();

}
