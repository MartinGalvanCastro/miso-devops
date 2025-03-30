package com.example.blacklistapi.domain.exception;

/**
 * Exception thrown when an operation is attempted without proper authorization.
 *
 * <p>Represents a specific case of {@code ApiException} with the status {@code
 * HttpStatus.UNAUTHORIZED}.
 */
public class NotAuthorizedException extends ApiException {

  /**
   * Constructs a new {@code NotAuthorizedException} with a default detail message and HTTP status.
   * The specified message is "Not Authorized" and the HTTP status is set to {@code
   * HttpStatus.UNAUTHORIZED}.
   */
  public NotAuthorizedException() {
    super("Not Authorized");
  }

  public NotAuthorizedException(String reason) {
    super(reason);
  }
}
