package br.com.senai.centroWeg.module.todo.application.dto;

import br.com.senai.centroWeg.module.todo.domain.model.StatusTodo;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record UpdateTodoRequest(
        @NotNull(message = "Status is required")
        StatusTodo statusTodo,
        
        @Positive(message = "User ID must be positive")
        int userId
) {
}
