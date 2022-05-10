package com.hd.subject.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Visit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "visit_id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "hospital_id")
  private Hospital hospital;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "patient_id")
  private Patient patient;

  private LocalDateTime receptionDate;

  @Builder
  public Visit(Hospital hospital, Patient patient, LocalDateTime receptionDate) {
    this.hospital = hospital;
    this.patient = patient;
    this.receptionDate = receptionDate;
  }
}
