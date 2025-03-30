package com.example.blacklistapi.application.ports.output;

import com.example.blacklistapi.domain.model.BlacklistEntry;
import java.util.Optional;

/**
 * Repository port interface for managing blacklist entries.
 *
 * <p>Provides methods to save a blacklist entry and find an entry by email.
 */
public interface BlacklistRepositoryPort {

  /**
   * Saves the given blacklist entry.
   *
   * @param blacklistEntry the blacklist entry to save
   * @return the saved {@link BlacklistEntry} instance
   */
  BlacklistEntry save(BlacklistEntry blacklistEntry);

  /**
   * Searches for a blacklist entry by the specified email address.
   *
   * @param email the email address to search for
   * @return an {@link Optional} containing the found {@link BlacklistEntry} if present, otherwise
   *     an empty {@code Optional}
   */
  Optional<BlacklistEntry> findByEmail(String email);
}
