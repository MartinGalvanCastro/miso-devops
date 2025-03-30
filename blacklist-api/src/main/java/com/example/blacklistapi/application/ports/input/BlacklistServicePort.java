package com.example.blacklistapi.application.ports.input;

import com.example.blacklistapi.application.dto.BlacklistRequest;
import com.example.blacklistapi.application.dto.BlacklistResponse;
import com.example.blacklistapi.application.dto.MessageResponse;
import com.example.blacklistapi.domain.exception.EmailBlacklistedException;

/**
 * Port for blacklist service operations.
 *
 * <p>Defines the operations for adding an email to the blacklist and checking if an email is
 * blacklisted.
 */
public interface BlacklistServicePort {

  /**
   * Adds an email to the blacklist.
   *
   * @param blacklistRequest contains the data required for blacklisting, including the email
   *     address.
   * @param clientIp the client's IP address.
   * @return a MessageResponse containing the result of the operation.
   * @throws EmailBlacklistedException if the email is already blacklisted.
   */
  MessageResponse addEmailToBlacklist(BlacklistRequest blacklistRequest, String clientIp)
      throws EmailBlacklistedException;

  /**
   * Checks if an email is blacklisted.
   *
   * @param email the email address to check
   * @return a {@code BlacklistResponse} indicating whether the email is blacklisted along with the
   *     reason
   */
  BlacklistResponse checkEmailBlackList(String email);
}
