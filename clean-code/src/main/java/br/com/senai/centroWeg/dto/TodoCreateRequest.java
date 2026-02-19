package br.com.senai.centroWeg.dto;

import br.com.senai.centroWeg.domain.StatusTodo;

public record TodoCreateRequest(
        String title,
        String Description,
        int authorId,
        StatusTodo statusTodo
) {

    public TodoCreateRequest {
        if(title.isBlank()) {
            throw new RuntimeException("Não pode ficar em branco");
        }
    }

}
