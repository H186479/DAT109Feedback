package com.example.dat109feedback.model;

import jakarta.persistence.*;

/**
 * Representerer en anonym tilbakemelding på en forelesning.
 * Inneholder GET/SET, Konstruktør og toString. Samt logikk for
 * database.
 */

@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "forelesning_id", nullable = false)
    private Forelesning forelesning;

    @Enumerated(EnumType.STRING)
    private FeedbackType type;

    public Feedback() {}

    public Feedback(Forelesning forelesning, FeedbackType type) {
        this.forelesning = forelesning;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Forelesning getForelesning() {
        return forelesning;
    }

    public void setForelesning(Forelesning forelesning) {
        this.forelesning = forelesning;
    }

    public FeedbackType getType() {
        return type;
    }

    public void setType(FeedbackType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", forelesning=" + forelesning +
                ", type=" + type +
                '}';
    }
}
