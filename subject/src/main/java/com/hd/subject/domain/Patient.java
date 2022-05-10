package com.hd.subject.domain;

import com.hd.subject.domain.status.GenderCode;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Patient {
  @Id
  @GeneratedValue
  @Column(name = "patient_id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "hospital_id")
  private Hospital hospital;

  @Column(length = 45)
  private String name;

  @Column(length = 13, unique = true)
  private String registrationNumber;

  @Column(length = 10)
  private GenderCode genderCode;

  @Column(length = 10)
  private String birthday;

  @Column(length = 20)
  private String phoneNumber;
}