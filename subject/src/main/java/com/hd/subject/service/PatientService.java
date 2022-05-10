package com.hd.subject.service;

import com.hd.subject.domain.Hospital;
import com.hd.subject.domain.Patient;
import com.hd.subject.domain.status.GenderCode;
import com.hd.subject.dto.request.SavePatientRequestDto;
import com.hd.subject.repository.HospitalRepository;
import com.hd.subject.repository.PatientRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
  private final HospitalRepository hospitalRepository;
  private final PatientRepository patientRepository;

  public void save(SavePatientRequestDto requestDto) {
    Hospital hospital = getHospital(requestDto.getHospitalId());
    Patient patient = Patient.builder()
        .hospital(hospital)
        .name(requestDto.getName())
        .phoneNumber(requestDto.getPhoneNumber())
        .genderCode(GenderCode.findCode(requestDto.getGenderCode()))
        .birthday(requestDto.getBirthday())
        .registrationNumber(UUID.randomUUID().toString())
        .build();
    patientRepository.save(patient);
  }

  public Hospital getHospital(Long hospitalId){
    return hospitalRepository.findById(hospitalId)
        .orElseThrow(IllegalArgumentException::new);
  }
}
