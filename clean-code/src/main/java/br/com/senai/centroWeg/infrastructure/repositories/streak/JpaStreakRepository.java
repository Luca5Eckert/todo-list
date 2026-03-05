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
    Optional<Streak> findActiveByUserId(@Param("userId") int userId, @Param("yesterday") LocalDate yesterday);

    @Query("""
                SELECT new br.com.senai.centroWeg.module.streak.domain.model.StreakAnalytics(
                    AVG(s.days),
                    currentS,
                    longestS
                )
                FROM Streak s
                LEFT JOIN Streak currentS ON currentS.userId = :userId 
                    AND currentS.last = (SELECT MAX(inner1.last) FROM Streak inner1 WHERE inner1.userId = :userId)
                LEFT JOIN Streak longestS ON longestS.userId = :userId 
                    AND longestS.days = (SELECT MAX(inner2.days) FROM Streak inner2 WHERE inner2.userId = :userId)
                WHERE s.userId = :userId
                GROUP BY currentS.id, longestS.id
            """)
    Optional<StreakAnalytics> findAnalyticsByUserId(@Param("userId") int userId);


}