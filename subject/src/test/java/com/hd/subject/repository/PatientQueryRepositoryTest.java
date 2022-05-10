package com.hd.subject.repository;


import com.hd.subject.domain.Patient;
import com.hd.subject.domain.status.GenderCode;
import com.hd.subject.dto.response.FindPatientResponseDto;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PatientQueryRepositoryTest {
  @Autowired
  private PatientQueryRepository patientQueryRepository;
  @Autowired
  private PatientRepository patientRepository;

  @Test
  public void 환자목록조회테스트() throws Exception{
    //given
    patientRepository.save(createPatient(1));
    patientRepository.save(createPatient(2));
    patientRepository.save(createPatient(3));
    patientRepository.save(createPatient(4));

    //when
    List<FindPatientResponseDto> resultList = patientQueryRepository.findByPageAndLimit(0, 4);

    //then
    Assertions.assertThat(resultList.size()).isEqualTo(4);
  }

  private Patient createPatient(int index){
    return Patient.builder()
        .birthday("2000.01.01")
        .genderCode(GenderCode.CODE_M)
        .name("name")
        .phoneNumber("010-1234-5678")
        .registrationNumber("01-00002"+index)
        .build();
  }
}