package com.ankit.poc.exception_handling;

public class UserInputException extends RuntimeException {
  private static final long serialVersionUID = 473987953920660133L;
  private final int errorCode;

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public int getErrorCode() {
    return errorCode;
  }

  public UserInputException(int errorCode, String message) {
    super(message);
    this.errorCode = errorCode;

  }

  @Override
  public String toString() {
    return "UserInputException [errorCode=" + errorCode + "]";
  }
}
