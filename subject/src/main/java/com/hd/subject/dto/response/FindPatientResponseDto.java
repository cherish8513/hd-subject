package com.hd.subject.dto.response;

import com.hd.subject.domain.Patient;
import com.hd.subject.domain.Visit;
import com.hd.subject.domain.status.GenderCode;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

public class FindPatientResponseDto {

  String name;
  String gender;
  String birthday;
  String phoneNumber;
  String registrationNumber;
  LocalDateTime visitedDate;

  public FindPatientResponseDto() {
  }

  public FindPatientResponseDto(String name, GenderCode gender, String birthday,
      String phoneNumber, String registrationNumber, LocalDateTime visitedDateList) {
    this.name = name;
    this.gender = gender.getDescription();
    this.birthday = birthday;
    this.phoneNumber = phoneNumber;
    this.registrationNumber = registrationNumber;
    this.visitedDate = visitedDateList;
  }

  public static FindPatientResponseDto of(Patient patient, List<Visit> visitList) {
    FindPatientResponseDto responseDto = new FindPatientResponseDto();

    responseDto.name = patient.getName();
    responseDto.gender = patient.getGenderCode().getDescription();
    responseDto.birthday = patient.getBirthday();
    responseDto.phoneNumber = patient.getPhoneNumber();
    responseDto.registrationNumber = patient.getRegistrationNumber();
    visitList.sort(new Comparator<Visit>() {
      @Override
      public int compare(Visit o1, Visit o2) {
        return o1.getReceptionDate().compareTo(o2.getReceptionDate());
      }
    });
    responseDto.visitedDate = visitList.get(0).getReceptionDate();
    return responseDto;
  }
}
