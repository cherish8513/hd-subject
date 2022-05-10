package com.hd.subject.domain.status;

import java.util.Arrays;
import lombok.Getter;

@Getter
public enum GenderCode {
  CODE_M("남", 'M'), CODE_F("여", 'F');

  private final String description;
  private final char code;

  GenderCode(String description, char code) {
    this.description = description;
    this.code = code;
  }

  public static GenderCode findCode(char code) {
    return Arrays.stream(values())
        .filter(m -> m.code == code)
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }
}
