package org.example.exception;

public class InvalidParameterArguments extends RuntimeException {

  public InvalidParameterArguments(String message) {
    super(message);
  }

  public InvalidParameterArguments(String message, Throwable cause) {
    super(message, cause);
  }
}
