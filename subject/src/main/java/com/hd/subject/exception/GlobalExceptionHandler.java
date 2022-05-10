package com.hd.subject.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(value = {IllegalArgumentException.class})
  public ResponseEntity<String> handleDataException() {
    return ResponseEntity.status(500).body("입력 값이 잘못되었습니다.");
  }
}
