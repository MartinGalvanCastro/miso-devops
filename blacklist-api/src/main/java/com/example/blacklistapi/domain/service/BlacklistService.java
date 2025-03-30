package com.example.blacklistapi.domain.service;

import com.example.blacklistapi.application.dto.BlacklistRequest;
import com.example.blacklistapi.application.dto.BlacklistResponse;
import com.example.blacklistapi.application.dto.MessageResponse;
import com.example.blacklistapi.application.ports.input.BlacklistServicePort;
import com.example.blacklistapi.application.ports.output.BlacklistRepositoryPort;
import com.example.blacklistapi.domain.exception.EmailBlacklistedException;
import com.example.blacklistapi.domain.model.BlacklistEntry;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Service for handling blacklist operations.
 *
 * <p>Implements the {@code BlacklistServicePort} to add emails to the blacklist and check if an
 * email is blacklisted.
 */
@Service
@RequiredArgsConstructor
public class BlacklistService implements BlacklistServicePort {

  private final BlacklistRepositoryPort repository;

  /**
   * Adds an email to the blacklist.
   *
   * <p>Checks if the email is already blacklisted, throwing an exception if it is. Otherwise, it
   * creates a new blacklist entry and saves it.
   *
   * @param blacklistRequest the email address to be blacklisted
   * @param clientIp the client IP address
   * @return a {@code MessageResponse} indicating successful blacklisting
   * @throws EmailBlacklistedException if the email is already blacklisted
   */
  @Override
  @Transactional
  public MessageResponse addEmailToBlacklist(BlacklistRequest blacklistRequest, String clientIp)
      throws EmailBlacklistedException {

    var existingEntry = repository.findByEmail(blacklistRequest.email());
    if (existingEntry.isPresent()) {
      throw new EmailBlacklistedException(blacklistRequest.email());
    }
    var blacklistEntry =
        BlacklistEntry.builder()
            .appUuid(blacklistRequest.appUuid())
            .blockedReason(blacklistRequest.blockedReason())
            .email(blacklistRequest.email())
            .clientIp(clientIp)
            .build();
    repository.save(blacklistEntry);
    return MessageResponse.builder()
        .message("Email: " + blacklistEntry.getEmail() + " has been blacklisted successfully.")
        .build();
  }

  /**
   * Checks if an email is blacklisted.
   *
   * <p>Returns a response indicating whether the email is blacklisted and if so, provides the
   * reason. If not, a default message is returned.
   *
   * @param email the email address to check
   * @return a {@code BlacklistResponse} containing the blacklist status and reason
   */
  @Override
  public BlacklistResponse checkEmailBlackList(String email) {
    var existingEntry = repository.findByEmail(email);
    if (existingEntry.isEmpty()) {
      return BlacklistResponse.builder()
          .isBlacklisted(false)
          .reason("Email: " + email + " is not blacklisted.")
          .build();
    }

    return BlacklistResponse.builder()
        .isBlacklisted(true)
        .reason(existingEntry.get().getBlockedReason())
        .build();
  }
}
