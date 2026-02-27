package br.com.senai.centroWeg.infrastructure.repositories.streak;

import br.com.senai.centroWeg.module.streak.domain.model.Streak;
import br.com.senai.centroWeg.module.streak.domain.model.StreakAnalytics;
import br.com.senai.centroWeg.module.streak.domain.repository.StreakRepository;

import java.util.List;
import java.util.Optional;

public class StreakRepositoryAdapter implements StreakRepository {
   
    private final JpaStreakRepository jpaStreakRepository;

    public StreakRepositoryAdapter(JpaStreakRepository jpaStreakRepository) {
        this.jpaStreakRepository = jpaStreakRepository;
    }

    @Override
    public Streak save(Streak todo) {
        return jpaStreakRepository.save(todo);
    }

    @Override
    public List<Streak> findAll() {
        return jpaStreakRepository.findAll();
    }

    @Override
    public Optional<Streak> findById(int Id) {
        return jpaStreakRepository.findById(Id);
    }

    @Override
    public Optional<Streak> findActiveByUserId(int userId) {
        return jpaStreakRepository.findActiveByUserId(userId);
    }

    @Override
    public List<Streak> findAllByUserId(int userId) {
        return jpaStreakRepository.findAllByUserId(userId);
    }

    @Override
    public Optional<StreakAnalytics> findAnalyticsByUserId(int userId) {
        return jpaStreakRepository.findAnalyticsByUserId(userId);
    }

}
