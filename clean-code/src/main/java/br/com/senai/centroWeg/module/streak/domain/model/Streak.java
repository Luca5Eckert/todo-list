package br.com.senai.centroWeg.module.streak.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "streaks")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Streak {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int userId;

    private int days;

    private LocalDate start;

    private LocalDate last;

    public void increment() {
        LocalDate today = LocalDate.now();

        if(this.last.equals(today)) {
            return;
        }

        this.days++;
        this.last = today;
    }

}
