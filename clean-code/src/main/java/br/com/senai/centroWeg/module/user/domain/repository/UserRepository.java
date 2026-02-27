package br.com.senai.centroWeg.module.user.domain.repository;

import br.com.senai.centroWeg.module.user.domain.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository  {

    User save(User todo);
    List<User> findAll();
    Optional<User> findById(int Id);
    User save(int id,User user);
    void delete(int id);
}
