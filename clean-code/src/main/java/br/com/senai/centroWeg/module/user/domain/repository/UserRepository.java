package br.com.senai.centroWeg.module.user.domain.repository;

import br.com.senai.centroWeg.module.user.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository  {

    User save(User todo);
    List<User> findAll();
    User findById(int Id);

}
