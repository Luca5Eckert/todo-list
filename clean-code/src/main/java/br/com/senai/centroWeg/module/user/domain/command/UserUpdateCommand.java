package br.com.senai.centroWeg.module.user.domain.command;

import br.com.senai.centroWeg.module.user.application.dto.UserCreateRequest;

public record UserUpdateCommand(
        int id,
        String name,
        String email
) {
    public static UserUpdateCommand of(int id,UserCreateRequest updateRequest){
        return new UserUpdateCommand(
                id,
                updateRequest.name(),
                updateRequest.email()
        );
    }
}
