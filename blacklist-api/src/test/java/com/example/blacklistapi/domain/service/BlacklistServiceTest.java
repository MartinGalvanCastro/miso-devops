package com.example.blacklistapi.domain.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.blacklistapi.application.dto.BlacklistRequest;
import com.example.blacklistapi.application.dto.BlacklistResponse;
import com.example.blacklistapi.application.dto.MessageResponse;
import com.example.blacklistapi.application.ports.output.BlacklistRepositoryPort;
import com.example.blacklistapi.domain.exception.EmailBlacklistedException;
import com.example.blacklistapi.domain.model.BlacklistEntry;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BlacklistServiceTest {

  @Mock BlacklistRepositoryPort repository;

  @InjectMocks BlacklistService service;

  static final UUID TEST_APP_UUID = UUID.fromString("b0d46a0f-1635-4cfd-8d7e-40eac89c7e7d");
  static final String TEST_BLOCKED_REASON = "spam";
  static final String TEST_EMAIL = "user@example.com";
  static final String TEST_CLIENT_IP = "127.0.0.1";

  @Test
  void addEmailToBlacklistShouldSucceedWhenEmailNotAlreadyBlacklisted()
      throws EmailBlacklistedException {
    var request =
        BlacklistRequest.builder()
            .appUuid(TEST_APP_UUID)
            .blockedReason(TEST_BLOCKED_REASON)
            .email(TEST_EMAIL)
            .build();
    when(repository.findByEmail(request.email())).thenReturn(Optional.empty());

    MessageResponse response = service.addEmailToBlacklist(request, TEST_CLIENT_IP);

    assertNotNull(response);
    assertTrue(response.message().contains(TEST_EMAIL));
    verify(repository).save(any(BlacklistEntry.class));
  }

  @Test
  void addEmailToBlacklistShouldThrowExceptionWhenEmailAlreadyBlacklisted() {
    var request =
        BlacklistRequest.builder()
            .appUuid(TEST_APP_UUID)
            .blockedReason(TEST_BLOCKED_REASON)
            .email(TEST_EMAIL)
            .build();
    when(repository.findByEmail(request.email()))
        .thenReturn(Optional.of(BlacklistEntry.builder().email(request.email()).build()));

    assertThrows(
        EmailBlacklistedException.class,
        () -> service.addEmailToBlacklist(request, TEST_CLIENT_IP));
  }

  @Test
  void checkEmailBlackListShouldReturnNotBlacklistedWhenEmailNotFound() {
    when(repository.findByEmail(TEST_EMAIL)).thenReturn(Optional.empty());

    BlacklistResponse response = service.checkEmailBlackList(TEST_EMAIL);

    assertFalse(response.isBlacklisted());
    assertTrue(response.reason().contains("is not blacklisted"));
  }

  @Test
  void checkEmailBlackListShouldReturnBlacklistedWhenEmailFound() {
    var entry =
        BlacklistEntry.builder().email(TEST_EMAIL).blockedReason(TEST_BLOCKED_REASON).build();
    when(repository.findByEmail(TEST_EMAIL)).thenReturn(Optional.of(entry));

    BlacklistResponse response = service.checkEmailBlackList(TEST_EMAIL);

    assertTrue(response.isBlacklisted());
    assertEquals(TEST_BLOCKED_REASON, response.reason());
  }
}
