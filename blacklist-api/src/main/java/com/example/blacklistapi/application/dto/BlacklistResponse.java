package com.example.blacklistapi.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

/**
 * Data transfer object for blacklist response.
 *
 * <p>Contains a flag indicating if the entity is blacklisted and the corresponding reason.
 *
 * @param isBlacklisted indicates whether the entity is blacklisted.
 * @param reason the reason for the blacklist status.
 */
@Builder
@Schema(
    description =
        "Data Transfer Object for blacklist responses. Contains a flag indicating if the entity is blacklisted and the corresponding reason.")
public record BlacklistResponse(
    @Schema(description = "Indicates whether the entity is blacklisted", example = "true")
        boolean isBlacklisted,
    @Schema(description = "The reason for the blacklist status", example = "spam") String reason) {}
