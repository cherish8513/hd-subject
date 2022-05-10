package com.hd.subject.repository;

import static com.hd.subject.domain.QPatient.*;
import static com.hd.subject.domain.QVisit.*;

import com.hd.subject.dto.response.FindPatientResponseDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Repository
public class PatientQueryRepositoryImpl implements PatientQueryRepository{

  private final JPAQueryFactory query;

  @Override
  public List<FindPatientResponseDto> findByPageAndLimit(int page, int limit) {
    return query.select(Projections.constructor(FindPatientResponseDto.class,
        patient.name,
        patient.genderCode,
        patient.birthday,
        patient.phoneNumber,
        patient.registrationNumber,
            JPAExpressions
                .select(visit.receptionDate)
                .from(visit)
                .where(visit.patient.id.eq(patient.id))
                .orderBy(visit.receptionDate.desc())))
        .from(patient)
        .offset(page)
        .limit(limit)
        .fetch();
  }
}
