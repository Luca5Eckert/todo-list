package br.com.senai.centroWeg.module.todo.application.dto;

import br.com.senai.centroWeg.module.todo.domain.model.StatusTodo;

public record UpdateTodoRequest(
        StatusTodo statusTodo,
        int userId
) {
}
