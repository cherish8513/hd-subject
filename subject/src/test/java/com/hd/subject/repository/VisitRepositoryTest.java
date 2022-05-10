package com.hd.subject.repository;


import com.hd.subject.domain.Visit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class VisitRepositoryTest {

  @Autowired
  private VisitRepository visitRepository;

  @Test
  public void savePatient() throws Exception {
    //given
    String format = "2022-01-01 13:59";
    LocalDateTime receptionDate = LocalDateTime.parse(format,
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    Visit visit = Visit.builder()
        .receptionDate(receptionDate)
        .build();
    //when
    Visit savedVisit = visitRepository.save(visit);

    //then
    Assertions.assertThat(savedVisit.getId()).isNotNull();
    Assertions.assertThat(savedVisit.getReceptionDate()).isEqualTo(receptionDate);
  }
}