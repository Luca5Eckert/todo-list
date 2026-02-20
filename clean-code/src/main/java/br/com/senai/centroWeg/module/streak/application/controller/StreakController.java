package br.com.senai.centroWeg.module.streak.application.controller;

import br.com.senai.centroWeg.module.streak.application.dto.StreakCreateRequest;
import br.com.senai.centroWeg.module.streak.application.dto.StreakResponse;
import br.com.senai.centroWeg.module.streak.domain.command.StreakCreateCommand;
import br.com.senai.centroWeg.module.streak.domain.service.StreakService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/streaks")
public class StreakController {

    private final StreakService service;

    public StreakController(StreakService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StreakResponse> create(StreakCreateRequest request) {
    }


}