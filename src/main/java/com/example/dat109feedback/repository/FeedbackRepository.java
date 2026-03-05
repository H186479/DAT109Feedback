package com.example.dat109feedback.repository;

import com.example.dat109feedback.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository som håndterer database-transaksjoner for feedback.
 */

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}