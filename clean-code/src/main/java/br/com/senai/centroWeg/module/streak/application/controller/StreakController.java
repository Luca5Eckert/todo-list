package br.com.senai.centroWeg.module.streak.application.controller;

import br.com.senai.centroWeg.module.streak.application.dto.StreakResponse;
import br.com.senai.centroWeg.module.streak.application.mapper.StreakMapper;
import br.com.senai.centroWeg.module.streak.domain.command.StreakGetAllByUserIdCommand;
import br.com.senai.centroWeg.module.streak.domain.command.StreakGetByIdCommand;
import br.com.senai.centroWeg.module.streak.domain.command.StreakGetByUserIdCommand;
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

    @GetMapping("{id}")
    public ResponseEntity<StreakResponse> getById(
            @PathVariable int id
    ) {
        var command = StreakGetByIdCommand.of(id);

        var streak = service.getById(command);

        return ResponseEntity.ok(mapper.toResponse(streak));
    }

    @GetMapping("users/{userId}/active")
    public ResponseEntity<StreakResponse> getActiveStreakByUserId(
            @PathVariable int userId
    ) {
        var command = StreakGetByUserIdCommand.of(userId);

        var streak = service.getByActiveByUserId(command);

        return ResponseEntity.ok(mapper.toResponse(streak));
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<List<StreakResponse>> getAllStreakByUserId(
            @PathVariable int userId
    ) {
        var command = StreakGetAllByUserIdCommand.of(userId);

        var streaks = service.getAllStreakByUserId(command);

        return ResponseEntity.ok(
                streaks.stream()
                        .map(mapper::toResponse)
                        .toList()
        );
    }
}