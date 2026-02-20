package br.com.senai.centroWeg.module.streak.domain.repository;

import br.com.senai.centroWeg.module.streak.domain.model.Streak;

import java.util.List;
import java.util.Optional;

public interface StreakRepository {

    Streak save(Streak todo);

    List<Streak> findAll();

    Optional<Streak> findById(int Id);

    Optional<Streak> findActiveByUserId(int i);

    List<Streak> findALlByUserId(int i);
}
