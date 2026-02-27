package br.com.senai.centroWeg.module.todo.domain.command;

import br.com.senai.centroWeg.module.todo.domain.model.StatusTodo;

public record UpdateTodoCommand(
        int todoId,
        StatusTodo status,
        int userId
) {
    public static UpdateTodoCommand of(int todoId, StatusTodo statusTodo, int userId) {
        return new UpdateTodoCommand(todoId, statusTodo, userId);
    }
}
