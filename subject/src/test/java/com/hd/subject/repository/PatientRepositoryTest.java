package com.hd.subject.repository;

import com.hd.subject.domain.Patient;
import com.hd.subject.domain.status.GenderCode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class PatientRepositoryTest {

  @Autowired
  private PatientRepository patientRepository;

  @Test
  public void savePatient() throws Exception {
    //given
    Patient patient = Patient.builder()
        .birthday("2000.01.01")
        .genderCode(GenderCode.CODE_M)
        .name("name")
        .phoneNumber("010-1234-5678")
        .registrationNumber("01-00002-0003")
        .build();
    //when
    Patient savedPatient = patientRepository.save(patient);

    //then
    Assertions.assertThat(savedPatient.getId()).isNotNull();
    Assertions.assertThat(savedPatient.getHospital()).isNull();
    Assertions.assertThat(savedPatient.getBirthday()).isEqualTo("2000.01.01");
    Assertions.assertThat(savedPatient.getName()).isEqualTo("name");
    Assertions.assertThat(savedPatient.getPhoneNumber()).isEqualTo("010-1234-5678");
    Assertions.assertThat(savedPatient.getRegistrationNumber()).isEqualTo("01-00002-0003");
  }
}