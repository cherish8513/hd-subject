package com.hd.subject.dto.request;

import lombok.Data;

@Data
public class ModifyPatientRequestDto {
  Long patientId;
  String name;
  String phoneNumber;
}
