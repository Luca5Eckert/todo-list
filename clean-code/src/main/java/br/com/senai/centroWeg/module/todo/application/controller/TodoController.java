package br.com.senai.centroWeg.module.todo.application.controller;

import br.com.senai.centroWeg.module.todo.dto.TodoCreateRequest;
import br.com.senai.centroWeg.module.todo.dto.TodoUpdateRequest;
import br.com.senai.centroWeg.module.todo.model.Todo;
import br.com.senai.centroWeg.module.todo.repository.TodoRepository;
import br.com.senai.centroWeg.module.todo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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