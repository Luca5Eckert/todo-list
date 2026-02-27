package br.com.senai.centroWeg.module.todo.application.dto;

import br.com.senai.centroWeg.module.todo.domain.model.StatusTodo;

public record TodoCreateRequest(
        String title,
        String Description,
        int authorId,
        StatusTodo statusTodo
) {

    public TodoCreateRequest {
        if(title.isBlank()) {
            throw new RuntimeException("O titulo deve ser preenchido");
        }
    }

}

