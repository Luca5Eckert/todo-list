package br.com.senai.centroWeg.infrastructure.repositories.streak;

import br.com.senai.centroWeg.module.streak.domain.model.Streak;
import br.com.senai.centroWeg.module.streak.domain.model.StreakAnalytics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface JpaStreakRepository extends JpaRepository<Streak, Integer> {

    List<Streak> findAllByUserId(int userId);

    @Query("SELECT s FROM Streak s WHERE s.userId = :userId AND s.last >= :yesterday")
    Optional<Streak> findActiveByUserId(int userId, LocalDate yesterday);

    @Query("""
                SELECT new br.com.senai.centroWeg.module.streak.domain.model.StreakAnalytics(
                    AVG(s.days),
                    (SELECT s_curr FROM Streak s_curr 
                     WHERE s_curr.userId = :userId 
                     ORDER BY s_curr.last DESC, s_curr.id DESC LIMIT 1),
                    (SELECT s_long FROM Streak s_long 
                     WHERE s_long.userId = :userId 
                     ORDER BY s_long.days DESC, s_long.id DESC LIMIT 1)
                )
                FROM Streak s
                WHERE s.userId = :userId
            """)
    Optional<StreakAnalytics> findAnalyticsByUserId(@Param("userId") int userId);


}