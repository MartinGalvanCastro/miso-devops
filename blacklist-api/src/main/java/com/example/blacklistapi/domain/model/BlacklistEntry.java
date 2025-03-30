package com.example.blacklistapi.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an entry in the email blacklist.
 *
 * <p>This class stores the email, the associated application UUID, the reason for blocking the
 * email, the client's IP address, and the timestamp when the entry was created.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BlacklistEntry {
  /** The unique identifier for the blacklist entry. */
  private UUID id;

  /** The blacklisted email address. */
  private String email;

  /** The UUID associated with the application. */
  private UUID appUuid;

  /** The reason for blocking the email. */
  private String blockedReason;

  /** The IP address of the client that originated the entry. */
  private String clientIp;

  /** The timestamp when the blacklist entry was created. */
  private LocalDateTime createdAt;
}
