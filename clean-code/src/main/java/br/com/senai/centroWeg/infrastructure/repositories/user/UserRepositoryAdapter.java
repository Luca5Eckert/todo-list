package br.com.senai.centroWeg.infrastructure.repositories.user;

import br.com.senai.centroWeg.module.user.domain.model.User;
import br.com.senai.centroWeg.module.user.domain.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryAdapter implements UserRepository {
    
    private final JpaUserRepository jpaUserRepository;

    public UserRepositoryAdapter(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public User save(User user) {
        return jpaUserRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return jpaUserRepository.findAll();
    }

    @Override
    public Optional<User> findById(int id) {
        return jpaUserRepository.findById(id);
    }

    @Override
    public User save(int id, User user) {
        user.setId(id);
        return jpaUserRepository.save(user);
    }

    @Override
    public void delete(int id) {
        jpaUserRepository.deleteById(id);
    }
}
