package com.hd.subject.controller;

import com.hd.subject.dto.SearchCondition;
import com.hd.subject.dto.request.ModifyPatientRequestDto;
import com.hd.subject.dto.request.SavePatientRequestDto;
import com.hd.subject.dto.response.FindPatientResponseDto;
import com.hd.subject.repository.PatientQueryRepository;
import com.hd.subject.repository.PatientRepository;
import com.hd.subject.service.PatientService;
import java.util.List;
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
  private final PatientQueryRepository patientQueryRepository;

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

  @GetMapping("/{patientId}")
  public ResponseEntity<FindPatientResponseDto> findOne(@PathVariable Long patientId) {
    FindPatientResponseDto responseDto = patientService.findOne(patientId);
    return ResponseEntity.status(200).body(responseDto);
  }

  @GetMapping("/name/{name}/{page}/{limit}")
  public ResponseEntity<List<FindPatientResponseDto>> findPageByName(@PathVariable String name, @PathVariable int page,
      @PathVariable int limit){
    SearchCondition condition = new SearchCondition();
    condition.setPatientName(name);
    List<FindPatientResponseDto> responseDto = patientQueryRepository.findByPageAndLimit(page-1,
        limit, condition);

    return ResponseEntity.status(200).body(responseDto);
  }

  @GetMapping("/birthday/{birthday}/{page}/{limit}")
  public ResponseEntity<List<FindPatientResponseDto>> findPageByBirthday(@PathVariable String birthday, @PathVariable int page,
      @PathVariable int limit){
    SearchCondition condition = new SearchCondition();
    condition.setBirthday(birthday);
    List<FindPatientResponseDto> responseDto = patientQueryRepository.findByPageAndLimit(page-1,
        limit, condition);

    return ResponseEntity.status(200).body(responseDto);
  }


  @GetMapping("/reg-num/{regNum}/{page}/{limit}")
  public ResponseEntity<List<FindPatientResponseDto>> findPageByRegNum(@PathVariable String regNum, @PathVariable int page,
      @PathVariable int limit){
    SearchCondition condition = new SearchCondition();
    condition.setRegistrationNumber(regNum);
    List<FindPatientResponseDto> responseDto = patientQueryRepository.findByPageAndLimit(page-1,
        limit, condition);

    return ResponseEntity.status(200).body(responseDto);
  }


}
