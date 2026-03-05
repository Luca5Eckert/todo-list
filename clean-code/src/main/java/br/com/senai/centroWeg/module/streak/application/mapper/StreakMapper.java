package br.com.senai.centroWeg.module.streak.application.mapper;

import br.com.senai.centroWeg.module.streak.application.dto.StreakAnalyticsResponse;
import br.com.senai.centroWeg.module.streak.application.dto.StreakResponse;
import br.com.senai.centroWeg.module.streak.domain.model.Streak;
import br.com.senai.centroWeg.module.streak.domain.model.StreakAnalytics;
import org.springframework.stereotype.Component;

@Component
public class StreakMapper {

    public StreakResponse toResponse(Streak streak) {
        if (streak == null) {
            return null;
        }
        return new StreakResponse(
                streak.getId(),
                streak.getUserId(),
                streak.getDays(),
                streak.getStart(),
                streak.getLast()
        );
    }

    public StreakAnalyticsResponse toAnalyticsResponse(StreakAnalytics analytics) {
        if (analytics == null) {
            return null;
        }
        var currentStreakResponse = toResponse(analytics.currentStreak());
        var longestStreakResponse = toResponse(analytics.longestStreak());

        return new StreakAnalyticsResponse(
                analytics.averageDaysStreak(),
                currentStreakResponse,
                longestStreakResponse
        );
    }

}
