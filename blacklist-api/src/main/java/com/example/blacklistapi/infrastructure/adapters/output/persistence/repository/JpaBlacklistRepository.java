package com.example.blacklistapi.infrastructure.adapters.output.persistence.repository;

import com.example.blacklistapi.infrastructure.adapters.output.persistence.entity.BlacklistEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for performing CRUD operations on {@link
 * com.example.blacklistapi.infrastructure.adapters.output.persistence.entity.BlacklistEntity}
 * entities.
 *
 * <p>Extends {@link JpaRepository} to provide basic persistence operations. Also provides a custom
 * finder method to retrieve a BlacklistEntity by email.
 */
@Repository
public interface JpaBlacklistRepository extends JpaRepository<BlacklistEntity, UUID> {

  /**
   * Finds a {@link
   * com.example.blacklistapi.infrastructure.adapters.output.persistence.entity.BlacklistEntity} by
   * its email address.
   *
   * @param email the email address of the blacklist entry to search for
   * @return an {@link Optional} containing the found BlacklistEntity if it exists, otherwise an
   *     empty Optional
   */
  Optional<BlacklistEntity> findByEmail(String email);
}
