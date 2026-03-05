package com.example.dat109feedback.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/**
 * Javaklasse som representerer en forelesning.
 */

@Entity
public class Forelesning {

        @Id
        @GeneratedValue
        private Long id;
        private String navn;
        private LocalDateTime startTid;
        private String lokasjon; //

    public Forelesning(String navn, LocalDateTime startTid, String lokasjon) {
        this.startTid = startTid;
        this.lokasjon = lokasjon;
        this.navn = navn;
    }

    public Forelesning() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public LocalDateTime getStartTid() {
        return startTid;
    }

    public void setStartTid(LocalDateTime startTid) {
        this.startTid = startTid;
    }

    public String getLokasjon() {
        return lokasjon;
    }

    public void setLokasjon(String lokasjon) {
        this.lokasjon = lokasjon;
    }

    @Override
    public String toString() {
        return "Forelesning{" +
                "id=" + id +
                ", navn='" + navn + '\'' +
                ", startTid=" + startTid +
                ", lokasjon='" + lokasjon + '\'' +
                '}';
    }
}
