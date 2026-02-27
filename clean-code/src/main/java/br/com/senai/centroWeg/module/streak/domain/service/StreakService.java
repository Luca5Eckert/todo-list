package br.com.senai.centroWeg.module.streak.domain.service;

import br.com.senai.centroWeg.module.streak.domain.query.GetStreaksByUserQuery;
import br.com.senai.centroWeg.module.streak.domain.query.GetStreakByIdQuery;
import br.com.senai.centroWeg.module.streak.domain.query.GetStreakAnalyticsQuery;
import br.com.senai.centroWeg.module.streak.domain.exception.StreakNotFoundException;
import br.com.senai.centroWeg.module.streak.domain.model.Streak;
import br.com.senai.centroWeg.module.streak.domain.model.StreakAnalytics;
import br.com.senai.centroWeg.module.streak.domain.repository.StreakRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StreakService {

    private final StreakRepository repository;

    public StreakService(StreakRepository repository) {
        this.repository = repository;
    }

    public Streak getById(GetStreakByIdQuery query) {
        return repository.findById(query.id())
                .orElseThrow(() -> new StreakNotFoundException(query.id()));
    }

    public Streak getActiveByUserId(GetStreaksByUserQuery query) {
        var yesterday = LocalDate.now().minusDays(1);

        return repository.findActiveByUserId(query.userId(), yesterday)
                .orElseThrow(() -> new StreakNotFoundException("Active streak not found."));
    }

    public List<Streak> getAllByUserId(GetStreaksByUserQuery query) {
        return repository.findAllByUserId(query.userId());
    }

    public StreakAnalytics getAnalyticsByUserId(GetStreakAnalyticsQuery query) {
        return repository.findAnalyticsByUserId(query.userId())
                .orElseThrow(() -> new StreakNotFoundException("Streak analytics not found."));
    }

}