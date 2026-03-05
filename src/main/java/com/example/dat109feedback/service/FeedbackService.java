package com.example.dat109feedback.service;

import com.example.dat109feedback.model.Feedback;
import com.example.dat109feedback.model.FeedbackType;
import com.example.dat109feedback.model.Forelesning;
import com.example.dat109feedback.model.VoterLog;
import com.example.dat109feedback.repository.FeedbackRepository;
import com.example.dat109feedback.repository.ForelesningRepository;
import com.example.dat109feedback.repository.VoterLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service-klasse som håndterer forretningslogikken for anonyme tilbakemeldinger.
 */
@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private VoterLogRepository voterLogRepository;

    @Autowired
    private ForelesningRepository forelesningRepository;


    /**
     * Metode for registrering av tilbakemelding.
     * Sjekker om studenten allerede har gitt tilbakemelding på forelesningen.
     * Sjekker også om forelesningen finnes.
     */

    @Transactional
    public void registrerTilbakemelding(String studentId, Long forelesningId, FeedbackType type) {

        if (voterLogRepository.existsByStudentIdAndForelesningId(studentId, forelesningId)) {
            throw new RuntimeException("Student har allerede gitt tilbakemelding på denne forelesningen.");
        }

        Forelesning forelesning = forelesningRepository.findById(forelesningId)
                .orElseThrow(() -> new RuntimeException("Forelesning ikke funnet."));

        voterLogRepository.save(new VoterLog(studentId, forelesning));
        feedbackRepository.save(new Feedback(forelesning, type));
    }
}