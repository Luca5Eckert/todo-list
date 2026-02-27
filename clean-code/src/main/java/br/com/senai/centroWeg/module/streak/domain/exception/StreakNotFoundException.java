package br.com.senai.centroWeg.module.streak.domain.exception;

public class StreakNotFoundException extends RuntimeException {
    public StreakNotFoundException(String message) {
        super(message);
    }

    public StreakNotFoundException(int streakId) {
        super("Streak with ID " + streakId + " not found.");
    }
}
