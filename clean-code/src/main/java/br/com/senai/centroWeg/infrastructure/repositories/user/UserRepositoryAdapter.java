package br.com.senai.centroWeg.infrastructure.repositories.user;

import br.com.senai.centroWeg.module.user.model.User;
import br.com.senai.centroWeg.module.user.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryAdapter implements UserRepository {
    @Override
    public User save(User todo) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return List.of();
    }

    @Override
    public Optional<User> findById(int Id) {
        return Optional.empty();
    }
}
