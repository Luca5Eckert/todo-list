package br.com.senai.centroWeg.module.streak.domain.query;

public record GetStreaksByUserQuery(
        int userId
) {

    public static GetStreaksByUserQuery of(int userId) {
        return new GetStreaksByUserQuery(userId);
    }
}
