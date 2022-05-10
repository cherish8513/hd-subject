package com.hd.subject.dto.response;

import com.hd.subject.domain.Patient;
import com.hd.subject.domain.status.GenderCode;
import javax.persistence.Column;

public class FindPatientResponseDto {

  String name;
  String gender;
  String birthday;
  String phoneNumber;
  String registrationNumber;

  public static FindPatientResponseDto of(Patient patient){
    FindPatientResponseDto responseDto = new FindPatientResponseDto();

    responseDto.name = patient.getName();
    responseDto.gender = patient.getGenderCode().getDescription();
    responseDto.birthday = patient.getBirthday();
    responseDto.phoneNumber = patient.getPhoneNumber();
    responseDto.registrationNumber = patient.getRegistrationNumber();

    return responseDto;
  }
}
