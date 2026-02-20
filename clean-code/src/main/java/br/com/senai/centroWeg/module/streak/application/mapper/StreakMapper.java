package br.com.senai.centroWeg.module.streak.application.mapper;

import br.com.senai.centroWeg.module.streak.application.dto.StreakAnalyticsResponse;
import br.com.senai.centroWeg.module.streak.application.dto.StreakResponse;
import br.com.senai.centroWeg.module.streak.domain.model.Streak;
import br.com.senai.centroWeg.module.streak.domain.model.StreakAnalytics;
import org.springframework.stereotype.Component;

@Component
public class StreakMapper {

    public StreakResponse toResponse(Streak streak) {
        return new StreakResponse(
                streak.getId(),
                streak.getUserId(),
                streak.getDays(),
                streak.getStart(),
                streak.getLast()
        );
    }

    public StreakAnalyticsResponse toAnalyticsResponse(StreakAnalytics analytics) {
        var currentStreakResponse = toResponse(analytics.getCurrentStreak());
        var longestStreakResponse = toResponse(analytics.getLongestStreak());

        return new StreakAnalyticsResponse(
                analytics.getAverageDaysStreak(),
                currentStreakResponse,
                longestStreakResponse
        );
    }

}
