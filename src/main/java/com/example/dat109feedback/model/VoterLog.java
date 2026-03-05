package com.example.dat109feedback.model;

import jakarta.persistence.*;

/**
 * Klasse for å holde styr på om en student allerede har gitt feedback for
 * gjeldende forelesning. Slik at den ikke kan gi enda en tilbakemelding.
 */


@Entity
@Table(name = "voter_log", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"student_id", "forelesning_id"})
})
public class VoterLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_id", nullable = false)
    private String studentId;

    @ManyToOne
    @JoinColumn(name = "forelesning_id", nullable = false)
    private Forelesning forelesning;

    public VoterLog() {}

    public VoterLog(String studentId, Forelesning forelesning) {
        this.studentId = studentId;
        this.forelesning = forelesning;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Forelesning getForelesning() {
        return forelesning;
    }

    public void setForelesning(Forelesning forelesning) {
        this.forelesning = forelesning;
    }

    public String toString() {
        return "VoterLog{" +
                "id=" + id +
                ", studentId='" + studentId + '\'' +
                ", forelesning=" + forelesning +
                '}';
    }
}


