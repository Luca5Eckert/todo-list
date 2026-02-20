package br.com.senai.centroWeg.module.user.application.controller;

import br.com.senai.centroWeg.module.user.application.dto.UserCreateRequest;
import br.com.senai.centroWeg.module.user.application.dto.UserResponse;
import br.com.senai.centroWeg.module.user.application.mapper.UserMapper;
import br.com.senai.centroWeg.module.user.domain.command.UserCreateCommand;
import br.com.senai.centroWeg.module.user.domain.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    private final UserMapper mapper;

    public UserController(UserService service, UserMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(UserCreateRequest request) {
        var command = UserCreateCommand.of(request);

        var user = service.create(command);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mapper.toResponse(user));
    }

}