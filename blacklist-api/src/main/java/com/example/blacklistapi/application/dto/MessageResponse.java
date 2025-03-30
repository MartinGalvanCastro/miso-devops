// File: blacklist-api/src/main/java/com/example/blacklistapi/application/dto/MessageResponse.java
package com.example.blacklistapi.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

/**
 * Data transfer object for message responses.
 *
 * <p>Contains the response message.
 *
 * @param message the response message content.
 */
@Builder
@Schema(description = "Data Transfer Object for message responses. Contains the response message.")
public record MessageResponse(
    @Schema(
            description = "The response message content",
            example = "Operation completed successfully")
        String message) {}
