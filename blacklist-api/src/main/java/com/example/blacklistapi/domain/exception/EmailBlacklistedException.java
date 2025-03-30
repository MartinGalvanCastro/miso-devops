package com.example.blacklistapi.domain.exception;

/**
 * Exception indicating that an email is blacklisted.
 *
 * <p>This exception is thrown when an attempt is made to use an email address that is present in
 * the blacklist.
 */
public class EmailBlacklistedException extends ApiException {

  /**
   * Constructs a new EmailBlacklistedException with a formatted error message including the
   * provided email.
   *
   * @param reason reason of the error
   */
  public EmailBlacklistedException(String reason) {
    super(reason);
  }
}
