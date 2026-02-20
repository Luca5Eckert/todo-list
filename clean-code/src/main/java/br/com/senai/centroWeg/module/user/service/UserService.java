package br.com.senai.centroWeg.module.user.service;

import br.com.senai.centroWeg.module.user.repository.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}
