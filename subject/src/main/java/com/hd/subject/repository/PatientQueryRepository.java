package com.hd.subject.repository;

import com.hd.subject.dto.response.FindPatientResponseDto;
import java.util.List;

public interface PatientQueryRepository {
  List<FindPatientResponseDto> findByPageAndLimit(int page, int limit);
}
