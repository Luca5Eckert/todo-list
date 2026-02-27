package br.com.senai.centroWeg.module.streak.domain.query;

public record GetStreakByIdQuery(int id) {
    public static GetStreakByIdQuery of(int id) {
        return new GetStreakByIdQuery(id);
    }
}

