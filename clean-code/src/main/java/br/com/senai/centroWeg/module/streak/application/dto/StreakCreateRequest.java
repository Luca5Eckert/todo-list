package br.com.senai.centroWeg.module.streak.application.dto;

import java.time.LocalDate;

public record StreakCreateRequest(
        int days,
        LocalDate start,
        LocalDate last
) {


}
