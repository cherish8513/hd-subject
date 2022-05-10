package com.hd.subject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Hospital {
  @Id
  @GeneratedValue
  @Column(name = "hospital_id")
  private Long id;

  @Column(length = 45)
  private String name;

  @Column(length = 20, unique = true)
  private String institutionNumber;

  @Column(length = 10)
  private String directorName;
}
