package br.com.senai.centroWeg.module.todo.application.dto;

import br.com.senai.centroWeg.module.todo.domain.model.StatusTodo;

public record TodoResponse(
        int id,
        String title,
        String Description,
        int authorId,
        StatusTodo statusTodo
) {
}
