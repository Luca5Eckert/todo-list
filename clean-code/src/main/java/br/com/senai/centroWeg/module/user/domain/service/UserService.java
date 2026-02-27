package br.com.senai.centroWeg.module.user.domain.service;

import br.com.senai.centroWeg.module.user.domain.command.UserCreateCommand;
import br.com.senai.centroWeg.module.user.domain.model.User;
import br.com.senai.centroWeg.module.user.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(UserCreateCommand command) {
        return userRepository.save(new User(command.name(), command.email())); // return the created user
    }

    public

}
