package br.com.senai.centroWeg.infrastructure.repositories.streak;

import br.com.senai.centroWeg.module.streak.model.Streak;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaStreakRepository extends JpaRepository<Streak, Integer> {

}
