package com.hd.subject.repository;

import static com.hd.subject.domain.QPatient.*;
import static com.hd.subject.domain.QVisit.*;
import static org.springframework.util.StringUtils.hasText;

import com.hd.subject.dto.SearchCondition;
import com.hd.subject.dto.response.FindPatientResponseDto;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
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
  public List<FindPatientResponseDto> findByPageAndLimit(int page, int limit, SearchCondition condition) {
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
        .where(
            patientNameEq(condition.getPatientName()),
            registrationNumberEq(condition.getRegistrationNumber()),
            birthdayEq(condition.getBirthday())
        )
        .offset(page)
        .limit(limit)
        .fetch();
  }

  private BooleanExpression patientNameEq(String patientName){
    return hasText(patientName) ? patient.name.eq(patientName) : null;
  }

  private BooleanExpression registrationNumberEq(String registrationNumber){
    return hasText(registrationNumber) ? patient.registrationNumber.eq(registrationNumber) : null;
  }

  private BooleanExpression birthdayEq(String birthday){
    return hasText(birthday) ? patient.birthday.eq(birthday) : null;
  }
}
