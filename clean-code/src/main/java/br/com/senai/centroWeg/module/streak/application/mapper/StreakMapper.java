package br.com.senai.centroWeg.module.streak.application.mapper;

import br.com.senai.centroWeg.module.streak.application.dto.StreakResponse;
import br.com.senai.centroWeg.module.streak.domain.model.Streak;
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
}
