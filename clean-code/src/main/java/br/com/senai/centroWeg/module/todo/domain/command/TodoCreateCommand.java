package br.com.senai.centroWeg.module.todo.domain.command;

import br.com.senai.centroWeg.module.todo.application.dto.TodoCreateRequest;
import br.com.senai.centroWeg.module.todo.domain.model.StatusTodo;

public record TodoCreateCommand(
        String title,
        String description,
        int authorId,
        StatusTodo statusTodo
) {
    public static TodoCreateCommand of(TodoCreateRequest request){
        return new TodoCreateCommand(
                request.title(),
                request.description(),
                request.authorId(),
                request.statusTodo()
        );
    }
}
