package br.com.senai.centroWeg.module.todo.application.dto;

import br.com.senai.centroWeg.module.todo.domain.model.StatusTodo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record TodoCreateRequest(
        @NotBlank(message = "Title is required")
        String title,
        
        String description,
        
        @Positive(message = "Author ID must be positive")
        int authorId,
        
        @NotNull(message = "Status is required")
        StatusTodo statusTodo
) {
}

