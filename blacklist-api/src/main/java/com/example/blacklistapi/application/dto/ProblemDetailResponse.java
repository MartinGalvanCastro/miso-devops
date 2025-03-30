package com.example.blacklistapi.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * RFC7807\-compliant problem detail response.
 *
 * <p>This record encapsulates information about a problem in a format consistent with RFC7807. It
 * includes details such as the problem type URI, title, status, detailed explanation, and a
 * specific instance reference.
 */
@Schema(description = "RFC7807 Problem Detail")
public record ProblemDetailResponse(
    /** A URI reference that identifies the problem type. Example: "about:blank" */
    @Schema(
            description = "A URI reference that identifies the problem type",
            example = "about:blank")
        String type,

    /** A short, human\-readable summary of the problem type. Example: "Bad Request". */
    @Schema(
            description = "A short, human-readable summary of the problem type",
            example = "Bad Request")
        String title,

    /** The HTTP status code. Example: 400. */
    @Schema(description = "The HTTP status code", example = "400") int status,

    /**
     * A human\-readable explanation of the error. Example: "A human\-readable explanation of the
     * error".
     */
    @Schema(
            description = "A human-readable explanation of the error",
            example = "A human-readable explanation of the error")
        String detail,

    /**
     * A URI reference that identifies the specific occurrence of the problem. Example:
     * "/api/v1/endpoint".
     */
    @Schema(
            description = "A URI reference that identifies the specific occurrence of the problem",
            example = "/api/v1/endpoint")
        String instance) {}
