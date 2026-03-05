package br.com.senai.centroWeg.module.streak.application.controller;

import br.com.senai.centroWeg.module.streak.application.dto.StreakAnalyticsResponse;
import br.com.senai.centroWeg.module.streak.application.dto.StreakResponse;
import br.com.senai.centroWeg.module.streak.application.mapper.StreakMapper;
import br.com.senai.centroWeg.module.streak.domain.query.GetStreakAnalyticsQuery;
import br.com.senai.centroWeg.module.streak.domain.query.GetStreakByIdQuery;
import br.com.senai.centroWeg.module.streak.domain.query.GetStreaksByUserQuery;
import br.com.senai.centroWeg.module.streak.domain.service.StreakService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/streaks")
public class StreakController {

    private final StreakService service;
    private final StreakMapper mapper;

    public StreakController(StreakService service, StreakMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StreakResponse> getById(@PathVariable("id") int id) {
        var query  = GetStreakByIdQuery.of(id);
        var streak = service.getById(query);

        return ResponseEntity.ok(mapper.toResponse(streak));
    }

    @GetMapping("/users/{userId}/active")
    public ResponseEntity<StreakResponse> getActiveByUserId(@PathVariable("userId") int userId) {
        var query  = GetStreaksByUserQuery.of(userId);
        var streak = service.getActiveByUserId(query);

        return ResponseEntity.ok(mapper.toResponse(streak));
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<StreakResponse>> getAllByUserId(@PathVariable("userId") int userId) {
        var query   = GetStreaksByUserQuery.of(userId);
        var streaks = service.getAllByUserId(query);

        var response = streaks.stream()
                .map(mapper::toResponse)
                .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/users/{userId}/analytics")
    public ResponseEntity<StreakAnalyticsResponse> getAnalytics(@PathVariable("userId") int userId) {
        var query     = GetStreakAnalyticsQuery.of(userId);
        var analytics = service.getAnalyticsByUserId(query);

        return ResponseEntity.ok(mapper.toAnalyticsResponse(analytics));
    }
}