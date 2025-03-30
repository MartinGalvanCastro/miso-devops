package com.example.blacklistapi.infrastructure.adapters.output.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.example.blacklistapi.domain.model.BlacklistEntry;
import com.example.blacklistapi.infrastructure.adapters.output.persistence.entity.BlacklistEntity;
import com.example.blacklistapi.infrastructure.adapters.output.persistence.mapper.BlacklistMapper;
import com.example.blacklistapi.infrastructure.adapters.output.persistence.repository.JpaBlacklistRepository;
import com.github.javafaker.Faker;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class JpaBlacklistRepositoryAdapterTest {

  @Mock private JpaBlacklistRepository repository;

  @Mock private BlacklistMapper mapper;

  @InjectMocks private JpaBlacklistRepositoryAdapter adapter;

  @Test
  void saveReturnsPersistedEntry() {
    BlacklistEntry inputEntry = generateMockBlacklistEntry();
    BlacklistEntity entity = new BlacklistEntity();

    when(mapper.toEntity(inputEntry)).thenReturn(entity);
    when(repository.save(entity)).thenReturn(entity);
    when(mapper.toDomain(entity)).thenReturn(inputEntry);

    BlacklistEntry result = adapter.save(inputEntry);
    assertNotNull(result);
    assertEquals(inputEntry, result);
  }

  @Test
  void findByEmailReturnsDomainWhenEntryExists() {
    BlacklistEntry domainEntry = generateMockBlacklistEntry();
    BlacklistEntity entity = new BlacklistEntity();
    String email = domainEntry.getEmail();

    when(repository.findByEmail(email)).thenReturn(Optional.of(entity));
    when(mapper.toDomain(entity)).thenReturn(domainEntry);

    Optional<BlacklistEntry> result = adapter.findByEmail(email);
    assertTrue(result.isPresent());
    assertEquals(domainEntry, result.get());
  }

  @Test
  void findByEmailReturnsEmptyWhenEntryNotFound() {
    String email = generateMockBlacklistEntry().getEmail();

    when(repository.findByEmail(email)).thenReturn(Optional.empty());
    Optional<BlacklistEntry> result = adapter.findByEmail(email);
    assertFalse(result.isPresent());
  }

  private BlacklistEntry generateMockBlacklistEntry() {
    Faker faker = new Faker();
    UUID id = UUID.randomUUID();
    String email = faker.internet().emailAddress();
    UUID appUuid = UUID.randomUUID();
    String blockedReason = faker.lorem().sentence();
    String clientIp = faker.internet().ipV4Address();
    LocalDateTime createdAt =
        LocalDateTime.ofInstant(
            faker.date().past(10, TimeUnit.DAYS).toInstant(), ZoneId.systemDefault());
    return new BlacklistEntry(id, email, appUuid, blockedReason, clientIp, createdAt);
  }
}
