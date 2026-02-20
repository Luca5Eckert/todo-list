package br.com.senai.centroWeg.module.todo.application.controller;

import br.com.senai.centroWeg.module.todo.application.dto.TodoUpdateRequest;
import br.com.senai.centroWeg.module.todo.domain.model.Todo;
import br.com.senai.centroWeg.module.todo.domain.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public Todo create(@Valid @RequestBody TodoUpdateRequest request){
        return service.create(request);
    }

}