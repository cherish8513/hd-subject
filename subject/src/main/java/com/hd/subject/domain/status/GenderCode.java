package com.hd.subject.domain.status;

public enum GenderCode {
  CODE_M("남"), CODE_F("여");

  private final String description;

  GenderCode(String description) {
    this.description = description;
  }
}
