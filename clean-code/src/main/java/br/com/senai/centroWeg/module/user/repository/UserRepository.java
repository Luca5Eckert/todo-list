package br.com.senai.centroWeg.module.user.repository;

import br.com.senai.centroWeg.module.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User todo);
    List<User> findAll();
    Optional<User> findById(int Id);

}
