package com.hd.subject.repository;

import com.hd.subject.domain.Visit;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Long> {

  List<Visit> findByPatientId(Long patientId);
}