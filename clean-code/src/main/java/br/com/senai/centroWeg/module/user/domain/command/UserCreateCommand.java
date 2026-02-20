package br.com.senai.centroWeg.module.user.domain.command;

import br.com.senai.centroWeg.module.user.application.dto.UserCreateRequest;

public record UserCreateCommand(
        String name,
        String email
) {
    public static UserCreateCommand of(UserCreateRequest request) {
        return new UserCreateCommand(
                request.name(),
                request.email()
        );
    }
}
