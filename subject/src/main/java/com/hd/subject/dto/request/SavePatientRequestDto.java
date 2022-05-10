package com.hd.subject.dto.request;

import lombok.Data;

@Data
public class SavePatientRequestDto {

  Long hospitalId;
  String name;
  String phoneNumber;
  String birthday;
  char genderCode;
}
