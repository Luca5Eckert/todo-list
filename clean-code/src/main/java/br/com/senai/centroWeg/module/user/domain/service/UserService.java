package br.com.senai.centroWeg.module.user.domain.service;

import br.com.senai.centroWeg.module.user.application.dto.UserResponse;
import br.com.senai.centroWeg.module.user.application.mapper.UserMapper;
import br.com.senai.centroWeg.module.user.domain.command.UserCreateCommand;
import br.com.senai.centroWeg.module.user.domain.command.UserUpdateCommand;
import br.com.senai.centroWeg.module.user.domain.exception.UserException;
import br.com.senai.centroWeg.module.user.domain.model.User;
import br.com.senai.centroWeg.module.user.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(
            UserRepository userRepository,
            UserMapper userMapper
    ) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public User create(UserCreateCommand command) {
        return userRepository.save(new User(command.name(), command.email())); //
        // does by lucas eckert
        // return the created user
    }

    public User findById(int id){
        return userRepository.findById(id)
                .orElseThrow(() -> new UserException("User not found"));
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User updateUser(UserUpdateCommand userUpdate){
        var user = new User(userUpdate.name(), userUpdate.email());

        return userRepository.save(
                userUpdate.id(),
                user
                );

    }

    public void deleteUser(int id){

        userRepository.delete(id);
    }

}
