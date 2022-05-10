package com.hd.subject.controller;

import com.hd.subject.dto.request.ModifyPatientRequestDto;
import com.hd.subject.dto.request.SavePatientRequestDto;
import com.hd.subject.repository.PatientRepository;
import com.hd.subject.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/patients")
@RequiredArgsConstructor
public class PatientController {
  private final PatientService patientService;
  private final PatientRepository patientRepository;

  @PostMapping
  public ResponseEntity<Void> save(@RequestBody SavePatientRequestDto requestDto) {
    patientService.save(requestDto);
    return ResponseEntity.status(200).build();
  }

  @PatchMapping
  public ResponseEntity<Void> modify(@RequestBody ModifyPatientRequestDto requestDto){
    patientService.modify(requestDto);
    return ResponseEntity.status(200).build();
  }
  @DeleteMapping("/{patientId}")
  public ResponseEntity<Void> delete(@PathVariable Long patientId) {
    patientRepository.deleteById(patientId);
    return ResponseEntity.status(200).build();
  }
}
