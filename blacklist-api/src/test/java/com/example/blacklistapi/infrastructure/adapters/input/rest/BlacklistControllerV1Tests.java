package com.example.blacklistapi.infrastructure.adapters.input.rest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.blacklistapi.application.dto.BlacklistRequest;
import com.example.blacklistapi.application.dto.BlacklistResponse;
import com.example.blacklistapi.application.dto.MessageResponse;
import com.example.blacklistapi.domain.exception.EmailBlacklistedException;
import com.example.blacklistapi.domain.exception.NotAuthorizedException;
import com.example.blacklistapi.domain.service.BlacklistService;
import com.example.blacklistapi.infrastructure.config.security.SecurityConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(BlacklistControllerV1.class)
@Import(SecurityConfig.class)
@AutoConfigureMockMvc(addFilters = true)
@TestPropertySource(properties = {"security.static-token=test-token"})
class BlacklistControllerV1Tests {

  @Autowired private MockMvc mockMvc;

  @MockitoBean private BlacklistService blacklistService;

  @Autowired private ObjectMapper objectMapper;

  static final UUID TEST_APP_UUID = UUID.fromString("b0d46a0f-1635-4cfd-8d7e-40eac89c7e7d");
  static final String TEST_BLOCKED_REASON = "spam";
  static final String TEST_EMAIL = "user@example.com";
  static final String VALID_TOKEN = "test-token";
  static final String INVALID_TOKEN = "invalid-token";

  @Test
  void addingEmailToBlacklistReturnsOk() throws Exception {
    var request =
        BlacklistRequest.builder()
            .appUuid(TEST_APP_UUID)
            .blockedReason(TEST_BLOCKED_REASON)
            .email(TEST_EMAIL)
            .build();
    MessageResponse response = new MessageResponse("Email added successfully");
    when(blacklistService.addEmailToBlacklist(any(BlacklistRequest.class), any(String.class)))
        .thenReturn(response);
    mockMvc
        .perform(
            post("/v1/blacklist")
                .header("Authorization", "Bearer " + VALID_TOKEN)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().isOk())
        .andExpect(content().json(objectMapper.writeValueAsString(response)));
  }

  @Test
  void addingEmailToBlacklistWithInvalidEmailReturnsBadRequest() throws Exception {
    var request =
        BlacklistRequest.builder()
            .appUuid(TEST_APP_UUID)
            .blockedReason(TEST_BLOCKED_REASON)
            .email("invalid-email")
            .build();
    mockMvc
        .perform(
            post("/v1/blacklist")
                .header("Authorization", "Bearer " + VALID_TOKEN)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType("application/problem+json"))
        .andExpect(jsonPath("$.title").value("Bad Request"))
        .andExpect(jsonPath("$.detail").exists());
  }

  @Test
  void checkBlacklistReturnsOk() throws Exception {
    BlacklistResponse response = new BlacklistResponse(true, "User is blacklisted");
    when(blacklistService.checkEmailBlackList(eq("user@example.com"))).thenReturn(response);
    mockMvc
        .perform(
            get("/v1/blacklist/user@example.com").header("Authorization", "Bearer " + VALID_TOKEN))
        .andExpect(status().isOk())
        .andExpect(content().json(objectMapper.writeValueAsString(response)));
  }

  @Test
  void checkBlacklistWithInvalidEmailReturnsBadRequest() throws Exception {
    mockMvc
        .perform(
            get("/v1/blacklist/invalid-email").header("Authorization", "Bearer " + VALID_TOKEN))
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType("application/problem+json"))
        .andExpect(jsonPath("$.title").value("Bad Request"))
        .andExpect(jsonPath("$.detail").exists());
  }

  @Test
  void addingEmailToBlacklistWhenEmailAlreadyBlacklistedReturnsConflict() throws Exception {
    var request =
        BlacklistRequest.builder()
            .appUuid(TEST_APP_UUID)
            .blockedReason(TEST_BLOCKED_REASON)
            .email(TEST_EMAIL)
            .build();
    when(blacklistService.addEmailToBlacklist(any(BlacklistRequest.class), any(String.class)))
        .thenThrow(new EmailBlacklistedException("Email already blacklisted"));
    mockMvc
        .perform(
            post("/v1/blacklist")
                .header("Authorization", "Bearer " + VALID_TOKEN)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().isConflict())
        .andExpect(content().contentType("application/problem+json"))
        .andExpect(jsonPath("$.title").value("Conflict"))
        .andExpect(jsonPath("$.detail").value("Email already blacklisted"));
  }

  @Test
  void addingEmailToBlacklistWhenNotAuthorizedReturnsUnauthorized() throws Exception {
    var request =
        BlacklistRequest.builder()
            .appUuid(TEST_APP_UUID)
            .blockedReason(TEST_BLOCKED_REASON)
            .email(TEST_EMAIL)
            .build();
    when(blacklistService.addEmailToBlacklist(any(BlacklistRequest.class), any(String.class)))
        .thenThrow(new NotAuthorizedException());
    // Use an invalid token to trigger unauthorized error
    mockMvc
        .perform(
            post("/v1/blacklist")
                .header("Authorization", "Bearer " + INVALID_TOKEN)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
        .andExpect(status().isUnauthorized())
        .andExpect(content().contentType("application/problem+json"))
        .andExpect(jsonPath("$.title").value("Unauthorized"))
        .andExpect(jsonPath("$.detail").exists());
  }
}
