package br.com.senai.centroWeg.module.user.application.controller;

import br.com.senai.centroWeg.module.user.application.dto.UserCreateRequest;
import br.com.senai.centroWeg.module.user.application.dto.UserResponse;
import br.com.senai.centroWeg.module.user.application.mapper.UserMapper;
import br.com.senai.centroWeg.module.user.domain.command.UserCreateCommand;
import br.com.senai.centroWeg.module.user.domain.command.UserUpdateCommand;
import br.com.senai.centroWeg.module.user.domain.model.User;
import br.com.senai.centroWeg.module.user.domain.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<UserResponse> create(@RequestBody @Valid UserCreateRequest request) {
        var command = UserCreateCommand.of(request);

        var user = service.create(command);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mapper.toResponse(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable("id") int id) {

        var user = service.findById(id);

        return ResponseEntity
                .ok(mapper.toResponse(user));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        List<User> users = service.findAll();

        var response = users.stream()
                .map(mapper::toResponse)
                .toList();

        return ResponseEntity.ok(response);

    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(
            @PathVariable("id") int id,
            @RequestBody @Valid UserCreateRequest user
    ){
        var command = UserUpdateCommand.of(id,user);

        var updateUser = service.updateUser(command);

        return ResponseEntity.ok(mapper.toResponse(updateUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id){

        service.deleteUser(id);

        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }

}