package com.ankit.poc.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(UserInputException.class)
  public ResponseEntity<ErrorDto> userError(UserInputException e) {
    return ResponseEntity.badRequest()
        .body(new ErrorDto("INVALID_INPUT", e.getMessage(), correlationId()));
  }

  private Object correlationId() {
    // TODO Auto-generated method stub
    return null;
  }

  @ExceptionHandler(ExternalServiceException.class)
  public ResponseEntity<ErrorDto> externalError(ExternalServiceException e) {
    // circuit-breaker may wrap, include retryable flag
    return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(
        new ErrorDto("EXTERNAL_SERVICE_UNAVAILABLE", "temporarily unavailable", correlationId()));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorDto> other(Exception e) {
    log.error("unexpected", e); // ensures stack captured
    return ResponseEntity.status(500)
        .body(new ErrorDto("INTERNAL", "internal error", correlationId()));
  }
}
