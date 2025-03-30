package com.example.blacklistapi.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.UUID;
import lombok.Builder;

@Schema(
    description =
        "Data Transfer Object for a blacklist request. Contains the email to be blacklisted, the unique identifier for the application, and an optional reason for blocking.")
@Builder
public record BlacklistRequest(
    @Schema(
            description = "The email address to be blacklisted; must be a valid non-blank email.",
            example = "user@example.com")
        @NotBlank(message = "Email cannot be blank")
        @Email(message = "Email is not valid")
        String email,
    @Schema(
            description = "The unique identifier of the application.",
            example = "b0d46a0f-1635-4cfd-8d7e-40eac89c7e7d")
        @NotNull(message = "App UUID cannot be null")
        UUID appUuid,
    @Schema(
            description =
                "The reason for blocking the email; can have a maximum of 255 characters.",
            example = "spam")
        @Size(max = 255, message = "Blocked reason cannot exceed 255 characters")
        String blockedReason) {}
