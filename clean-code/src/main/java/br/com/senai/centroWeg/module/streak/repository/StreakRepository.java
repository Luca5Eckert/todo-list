package br.com.senai.centroWeg.module.streak.repository;

import br.com.senai.centroWeg.module.streak.model.Streak;

import java.util.List;
import java.util.Optional;

public interface StreakRepository {

    Streak save(Streak todo);
    List<Streak> findAll();
    Optional<Streak> findById(int Id);

}
