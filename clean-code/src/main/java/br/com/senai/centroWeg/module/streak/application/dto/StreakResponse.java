package br.com.senai.centroWeg.module.streak.application.dto;

import java.time.LocalDate;

public record StreakResponse(
        int id,
        int userId,
        int days,
        LocalDate start,
        LocalDate last
) {
}
