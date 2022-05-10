package com.hd.subject.service;

import com.hd.subject.domain.Hospital;
import com.hd.subject.domain.Patient;
import com.hd.subject.domain.Visit;
import com.hd.subject.domain.status.GenderCode;
import com.hd.subject.dto.request.ModifyPatientRequestDto;
import com.hd.subject.dto.request.SavePatientRequestDto;
import com.hd.subject.dto.response.FindPatientResponseDto;
import com.hd.subject.repository.HospitalRepository;
import com.hd.subject.repository.PatientRepository;
import com.hd.subject.repository.VisitRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

  private final HospitalRepository hospitalRepository;
  private final PatientRepository patientRepository;
  private final VisitRepository visitRepository;

  public void save(SavePatientRequestDto requestDto) {
    Hospital hospital = getHospital(requestDto.getHospitalId());
    Patient patient = Patient.builder()
        .hospital(hospital)
        .name(requestDto.getName())
        .phoneNumber(requestDto.getPhoneNumber())
        .genderCode(GenderCode.findCode(requestDto.getGenderCode()))
        .birthday(requestDto.getBirthday())
        .registrationNumber(UUID.randomUUID().toString().substring(0, 10))
        .build();
    patientRepository.save(patient);
  }

  public void modify(ModifyPatientRequestDto requestDto) {
    Patient patient = getPatient(requestDto.getPatientId());

    if (requestDto.getName() != null) {
      patient.changeName(requestDto.getName());
    }
    if (requestDto.getPhoneNumber() != null) {
      patient.changePhoneNumber(requestDto.getPhoneNumber());
    }
  }

  public FindPatientResponseDto findOne(Long patientId) {
    Patient patient = getPatient(patientId);
    List<Visit> listVisited = visitRepository.findByPatientId(patientId);

    return FindPatientResponseDto.of(patient, listVisited);
  }

  private Hospital getHospital(Long hospitalId) {
    return hospitalRepository.findById(hospitalId)
        .orElseThrow(IllegalArgumentException::new);
  }


  private Patient getPatient(Long patientId) {
    return patientRepository.findById(patientId)
        .orElseThrow(IllegalArgumentException::new);
  }

}
