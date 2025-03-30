package com.example.blacklistapi.infrastructure.adapters.output.persistence;

import com.example.blacklistapi.application.ports.output.BlacklistRepositoryPort;
import com.example.blacklistapi.domain.model.BlacklistEntry;
import com.example.blacklistapi.infrastructure.adapters.output.persistence.mapper.BlacklistMapper;
import com.example.blacklistapi.infrastructure.adapters.output.persistence.repository.JpaBlacklistRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Adapter class that implements the {@code BlacklistRepositoryPort} interface to provide data
 * access methods for blacklist entries using JPA.
 */
@Component
@RequiredArgsConstructor
public class JpaBlacklistRepositoryAdapter implements BlacklistRepositoryPort {

  /** Repository instance for performing JPA operations on the blacklist entries. */
  private final JpaBlacklistRepository repository;

  /** Mapper instance to convert between domain model and persistence entity. */
  private final BlacklistMapper mapper;

  /**
   * Saves a blacklist entry.
   *
   * <p>This method converts the domain model {@code BlacklistEntry} to a persistence entity,
   * persists it using the JPA repository, and converts the saved entity back to the domain model.
   *
   * @param blacklistEntry the blacklist entry domain object to save.
   * @return the persisted blacklist entry in domain model format.
   */
  @Override
  public BlacklistEntry save(BlacklistEntry blacklistEntry) {
    var mappedEntity = mapper.toEntity(blacklistEntry);
    var savedEntity = repository.save(mappedEntity);
    return mapper.toDomain(savedEntity);
  }

  /**
   * Finds a blacklist entry by email.
   *
   * <p>This method queries the JPA repository for a blacklist entry by its email. If found, it
   * converts the corresponding persistence entity to the domain model.
   *
   * @param email the email address to search for.
   * @return an {@code Optional} containing the found {@code BlacklistEntry} domain object, or an
   *     empty {@code Optional} if no entry is found.
   */
  @Override
  public Optional<BlacklistEntry> findByEmail(String email) {
    var entityOptional = repository.findByEmail(email);
    return entityOptional.map(mapper::toDomain);
  }
}
