package br.com.senai.centroWeg.module.streak.model;

import java.time.LocalDate;

public class Streak {

    private int id;

    private int userId;

    private int days;

    private LocalDate start;

    private LocalDate last;

    public Streak(int id, int userId, int days, LocalDate start, LocalDate last) {
        this.id = id;
        this.userId = userId;
        this.days = days;
        this.start = start;
        this.last = last;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getLast() {
        return last;
    }

    public void setLast(LocalDate last) {
        this.last = last;
    }

}
