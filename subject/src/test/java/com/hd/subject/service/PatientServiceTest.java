package com.hd.subject.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.OPTIONAL;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.hd.subject.domain.Hospital;
import com.hd.subject.domain.Patient;
import com.hd.subject.dto.request.SavePatientRequestDto;
import com.hd.subject.repository.HospitalRepository;
import com.hd.subject.repository.PatientRepository;
import com.hd.subject.repository.VisitRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PatientServiceTest {

  @InjectMocks
  private PatientService target;
  @Mock
  private PatientRepository patientRepository;
  @Mock
  private HospitalRepository hospitalRepository;

  @Test
  public void 환자등록실패_병원이존재하지않음() throws Exception {
    //given
    SavePatientRequestDto requestDto = createSaveReuqestDto();

    //when
    final IllegalArgumentException result = assertThrows(IllegalArgumentException.class,
        () -> target.save(requestDto));

    //then
    assertThat(result.getClass()).isEqualTo(IllegalArgumentException.class);
  }

  @Test
  public void 환자등록성공() throws Exception {
    //given
    doReturn(Optional.of(Hospital.builder().build())).when(hospitalRepository).findById(anyLong());
    SavePatientRequestDto requestDto = createSaveReuqestDto();

    //when
    target.save(requestDto);

    //then
    verify(hospitalRepository, times(1)).findById(1L);
    verify(patientRepository, times(1)).save(any(Patient.class));
  }

  private SavePatientRequestDto createSaveReuqestDto(){
    SavePatientRequestDto requestDto = new SavePatientRequestDto();
    requestDto.setName("name");
    requestDto.setBirthday("2000-01-01");
    requestDto.setPhoneNumber("010-1234-5678");
    requestDto.setHospitalId(1L);
    requestDto.setGenderCode('M');

    return requestDto;
  }
}