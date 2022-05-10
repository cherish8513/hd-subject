package com.hd.subject.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Visit {
  @Id
  @GeneratedValue
  @Column(name = "visit_id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "hospital_id")
  private Hospital hospital;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "patient_id")
  private Patient patient;

  private LocalDateTime receptionDate;

}
