package com.ankit.poc.exception_handling;

public class ExternalServiceException extends RuntimeException {
  private static final long serialVersionUID = 473987953920660133L;
  private final int errorCode;

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public int getErrorCode() {
    return errorCode;
  }

  public ExternalServiceException(int errorCode, String message) {
    super(message);
    this.errorCode = errorCode;
  }

  @Override
  public String toString() {
    return "ExternalServiceException [errorCode=" + errorCode + "]";
  }
}
