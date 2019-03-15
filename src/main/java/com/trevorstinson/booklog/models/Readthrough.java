package com.trevorstinson.booklog.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

public class Readthrough {

    @Id
    @GeneratedValue
    private int id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateStarted;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateFinished;



    public Readthrough() {
    }

    public Readthrough(int id, LocalDate dateStarted, LocalDate dateFinished) {
        this.id = id;
        this.dateStarted = dateStarted;
        this.dateFinished = dateFinished;
    }


    public int getId() {
        return id;
    }

    public LocalDate getDateStarted() {
        return dateStarted;
    }

    public void setDateStarted(LocalDate dateStarted) {
        this.dateStarted = dateStarted;
    }

    public LocalDate getDateFinished() {
        return dateFinished;
    }

    public void setDateFinished(LocalDate dateFinished) {
        this.dateFinished = dateFinished;
    }
}
