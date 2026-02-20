package br.com.senai.centroWeg.infrastructure.repositories.user;

import br.com.senai.centroWeg.module.user.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends JpaRepository<User, Integer> {
}