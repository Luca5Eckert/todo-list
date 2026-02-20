package br.com.senai.centroWeg.module.todo.dto;

import br.com.senai.centroWeg.module.todo.model.StatusTodo;

public record TodoUpdateRequest(
        String title,
        String Description,
        int authorId,
        StatusTodo statusTodo
) {

    public TodoUpdateRequest {
        if(title.isBlank()) {
            throw new RuntimeException("Não pode ficar em branco");
        }
    }

}
