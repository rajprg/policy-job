package com.assignment.policyjob.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class DataException extends Exception {

  private final String errorCode;
  private final String errorMessage;
  private final HttpStatus httpStatus;
  private final String errorCause;

  public DataException(
      final String errorCode,
      final String errorMessage,
      final HttpStatus httpStatus,
      final String errorCause) {
    super(errorMessage);
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
    this.httpStatus = httpStatus;
    this.errorCause = errorCause;
  }
}
