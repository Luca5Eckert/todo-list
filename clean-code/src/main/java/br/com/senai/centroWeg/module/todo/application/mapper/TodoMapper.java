package br.com.senai.centroWeg.module.todo.application.mapper;

import br.com.senai.centroWeg.module.todo.application.dto.TodoResponse;
import br.com.senai.centroWeg.module.todo.domain.model.Todo;

import java.util.Optional;

public class TodoMapper {
    public TodoResponse toResponse(Todo todo) {
        return new TodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.getAuthorId(),
                todo.getStatusTodo()
        );
    }
}
