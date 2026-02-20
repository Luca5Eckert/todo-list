package br.com.senai.centroWeg.module.streak.application.controller;

import br.com.senai.centroWeg.module.streak.application.dto.StreakGetByIdRequest;
import br.com.senai.centroWeg.module.streak.application.dto.StreakResponse;
import br.com.senai.centroWeg.module.streak.application.mapper.StreakMapper;
import br.com.senai.centroWeg.module.streak.domain.command.StreakGetByIdCommand;
import br.com.senai.centroWeg.module.streak.domain.service.StreakService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            @PathVariable StreakGetByIdRequest request
    ) {
        var command = StreakGetByIdCommand.of(request.streakId());

        var streak = service.getById(command);

        return ResponseEntity.ok(mapper.toResponse(streak));
    }


}