package com.example.blacklistapi.infrastructure.adapters.output.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

/**
 * Represents an entry in the blacklist.
 *
 * <p>This entity stores information about a blacklisted email for a specific application, including
 * the reason for being blocked, client IP, and creation timestamp.
 */
@Entity
@Table(name = "blacklist_entries")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BlacklistEntity {

  /**
   * Unique identifier for the blacklist entry.
   *
   * <p>Automatically generated using UUID strategy.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  /**
   * Email address that is blacklisted.
   *
   * <p>This field is unique and cannot be null.
   */
  @Column(nullable = false, unique = true)
  private String email;

  /**
   * Unique identifier of the application associated with the blacklist entry.
   *
   * <p>This field references an application in the system and cannot be null.
   */
  @Column(name = "app_uuid", nullable = false)
  private UUID appUuid;

  /**
   * Reason for blocking the email.
   *
   * <p>This field can store a description for why the email was blacklisted.
   */
  @Column(name = "blocked_reason", length = 255)
  private String blockedReason;

  /**
   * IP address of the client from where the blacklist entry was created.
   *
   * <p>This field cannot be null.
   */
  @Column(name = "client_ip", nullable = false)
  private String clientIp;

  /**
   * Timestamp when the blacklist entry was created.
   *
   * <p>This field captures the creation time and cannot be null.
   */
  @Column(name = "created_at", nullable = false)
  @CreationTimestamp
  private LocalDateTime createdAt;
}
