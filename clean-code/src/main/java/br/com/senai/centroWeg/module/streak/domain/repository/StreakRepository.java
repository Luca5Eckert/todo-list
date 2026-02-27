package br.com.senai.centroWeg.module.streak.domain.repository;

import br.com.senai.centroWeg.module.streak.domain.model.Streak;
import br.com.senai.centroWeg.module.streak.domain.model.StreakAnalytics;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface StreakRepository {

    Streak save(Streak todo);

    List<Streak> findAll();

    Optional<Streak> findById(int Id);

    Optional<Streak> findActiveByUserId(int userId, LocalDate yesterday);

    List<Streak> findAllByUserId(int userId);

    Optional<StreakAnalytics> findAnalyticsByUserId(int userId);
}
