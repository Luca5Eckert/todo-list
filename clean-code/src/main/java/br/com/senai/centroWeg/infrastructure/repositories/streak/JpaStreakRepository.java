package br.com.senai.centroWeg.infrastructure.repositories.streak;

import br.com.senai.centroWeg.module.streak.domain.model.Streak;
import br.com.senai.centroWeg.module.streak.domain.model.StreakAnalytics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
        SELECT
            (SELECT AVG(s.days) FROM Streak s WHERE s.userId = :userId) as averageDaysStreak,
            (SELECT s1 FROM Streak s1 WHERE s1.userId = :userId ORDER BY s1.last DESC LIMIT 1) as currentStreak,
            (SELECT s2 FROM Streak s2 WHERE s2.userId = :userId ORDER BY s2.days DESC LIMIT 1) as longestStreak
        FROM Streak s_root WHERE s_root.userId = :userId
        GROUP BY s_root.userId
    """)
    Optional<StreakAnalytics> findAnalyticsByUserId(int userId);

}