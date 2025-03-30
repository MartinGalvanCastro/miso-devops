package com.example.blacklistapi.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Abstract base class for API exceptions.
 *
 * <p>Provides a structure for exception details including an error message, an HTTP status code,
 * and an application‐specific error code.
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public abstract class ApiException extends RuntimeException {

  /** The error message describing the exception. */
  private String reason;
}
