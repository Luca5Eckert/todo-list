package br.com.senai.centroWeg.infrastructure.repositories.streak;

import br.com.senai.centroWeg.module.streak.model.Streak;
import br.com.senai.centroWeg.module.streak.repository.StreakRepository;

import java.util.List;
import java.util.Optional;

public class StreakRepositoryAdapter implements StreakRepository {
    @Override
    public Streak save(Streak todo) {
        return null;
    }

    @Override
    public List<Streak> findAll() {
        return List.of();
    }

    @Override
    public Optional<Streak> findById(int Id) {
        return Optional.empty();
    }
}
