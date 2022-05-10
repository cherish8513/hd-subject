package com.hd.subject.domain.status;

public enum ReceptionCode {
  CODE_1("방문중"), CODE_2("종료"), CODE_3("취소");

  private final String description;

  ReceptionCode(String description) {
    this.description = description;
  }
}
