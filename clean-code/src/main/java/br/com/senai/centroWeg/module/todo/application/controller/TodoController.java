package br.com.senai.centroWeg.module.todo.application.controller;

import br.com.senai.centroWeg.module.todo.application.dto.TodoCreateRequest;
import br.com.senai.centroWeg.module.todo.application.dto.TodoResponse;
import br.com.senai.centroWeg.module.todo.application.dto.UpdateTodoRequest;
import br.com.senai.centroWeg.module.todo.domain.command.TodoCreateCommand;
import br.com.senai.centroWeg.module.todo.domain.command.UpdateTodoCommand;
import br.com.senai.centroWeg.module.todo.domain.query.GetTodoByIdQuery;
import br.com.senai.centroWeg.module.todo.application.mapper.TodoMapper;
import br.com.senai.centroWeg.module.todo.domain.query.GetTodoByUserQuery;
import br.com.senai.centroWeg.module.todo.domain.service.TodoService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoService service;
    private final TodoMapper mapper;

    public TodoController(TodoService service, TodoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<TodoResponse> create (@RequestBody TodoCreateRequest request){
        var command = TodoCreateCommand.of(request);
        var todo = service.create(command);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(mapper.toResponse(todo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponse> getById(@PathVariable int id) {
        var query  = GetTodoByIdQuery.of(id);
        var todo = service.findById(query);

        return ResponseEntity.ok(mapper.toResponse(todo));
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<TodoResponse>> getAllByUserId(
            @PathVariable int userId
    ){
        var query = GetTodoByUserQuery.of(userId);
        var todolist = service.getAllByUserId(query);

        var response = todolist.stream()
                .map(mapper::toResponse)
                .toList();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    public void deleteByTodoId(int userId){
        var query = GetTodoByUserQuery.of(userId);
        service.deleteById(query);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(
            @PathVariable int id,
            @RequestBody @Valid UpdateTodoRequest request
    ){
        var command = UpdateTodoCommand.of(id, request.statusTodo(), request.userId());
        service.update(command);

        return ResponseEntity.noContent().build();
    }


}