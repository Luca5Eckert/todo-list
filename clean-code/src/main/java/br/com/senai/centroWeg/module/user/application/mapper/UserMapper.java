package br.com.senai.centroWeg.module.user.application.mapper;

import br.com.senai.centroWeg.module.user.application.dto.UserCreateRequest;
import br.com.senai.centroWeg.module.user.application.dto.UserResponse;
import br.com.senai.centroWeg.module.user.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    public User toEntity(UserCreateRequest userCreateRequest){
        return new User(
                userCreateRequest.name(),
                userCreateRequest.email()
        );
    }

}
