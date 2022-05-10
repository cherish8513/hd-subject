package com.hd.subject.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Hospital {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "hospital_id")
  private Long id;

  @Column(length = 45)
  private String name;

  @Column(length = 20, unique = true)
  private String institutionNumber;

  @Column(length = 10)
  private String directorName;

  @Builder
  public Hospital(String name, String institutionNumber, String directorName) {
    this.name = name;
    this.institutionNumber = institutionNumber;
    this.directorName = directorName;
  }
}
