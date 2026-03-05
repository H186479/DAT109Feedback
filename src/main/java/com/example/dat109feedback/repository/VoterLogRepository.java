package com.example.dat109feedback.repository;

import com.example.dat109feedback.model.VoterLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for håndtering av VoterLog mot PostgreSQL.
 */

@Repository
public interface VoterLogRepository extends JpaRepository<VoterLog, Long> {
    boolean existsByStudentIdAndForelesningId(String studentId, Long forelesningId);
}
