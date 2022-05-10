package com.hd.subject.domain.status;

public enum ReceptionCode {
  CODE_1("방문중", 1), CODE_2("종료", 2), CODE_3("취소", 3);

  private final String description;
  private final int code;

  ReceptionCode(String description, int code) {
    this.description = description;
    this.code = code;
  }
}
