package br.com.senai.centroWeg.module.streak.domain.command;

import java.time.LocalDate;

public record StreakCreateCommand(
        int userId,
        int days,
        LocalDate start,
        LocalDate last
) {
}
