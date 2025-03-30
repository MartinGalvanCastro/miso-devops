package com.example.blacklistapi.infrastructure.adapters.input.rest;

import com.example.blacklistapi.application.dto.BlacklistRequest;
import com.example.blacklistapi.application.dto.BlacklistResponse;
import com.example.blacklistapi.application.dto.MessageResponse;
import com.example.blacklistapi.application.dto.ProblemDetailResponse;
import com.example.blacklistapi.domain.service.BlacklistService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for handling blacklist operations.
 *
 * <p>This REST Controller provides endpoints to add an email to the blacklist and check if an email
 * is blacklisted. It leverages the {@link com.example.blacklistapi.domain.service.BlacklistService}
 * for business logic. All endpoints are secured using bearer authentication and documented using
 * OpenAPI annotations.
 *
 * @author
 */
@Tag(name = "Blacklist API", description = "Endpoints for blacklist operations.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/blacklist")
@SecurityRequirement(name = "bearerAuth")
public class BlacklistControllerV1 {

  private final BlacklistService blacklistService;

  /**
   * Endpoint to add an email to the blacklist.
   *
   * <p>This method accepts a {@link com.example.blacklistapi.application.dto.BlacklistRequest}
   * containing the email to be blacklisted and uses the client's remote IP from the HTTP request
   * for identification/logging purposes. Successful execution returns an operation status message.
   *
   * @param request the blacklist request payload that should be valid according to the specified
   *     constraints.
   * @param httpServletRequest the HTTP request used to obtain the client's remote IP address.
   * @return a {@link ResponseEntity} encapsulating a {@link
   *     com.example.blacklistapi.application.dto.MessageResponse} indicating the outcome of the
   *     operation.
   */
  @Operation(
      summary = "Add an email to the blacklist",
      description =
          "Accepts a blacklist request and uses the client's remote IP fetched from the HTTP request.")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Operation completed successfully",
            content =
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = MessageResponse.class))),
        @ApiResponse(
            responseCode = "400",
            description = "Body request is invalid",
            content =
                @Content(
                    mediaType = "application/problem+json",
                    schema = @Schema(implementation = ProblemDetailResponse.class))),
        @ApiResponse(
            responseCode = "401",
            description = "Unauthorized",
            content =
                @Content(
                    mediaType = "application/problem+json",
                    schema = @Schema(implementation = ProblemDetailResponse.class))),
        @ApiResponse(
            responseCode = "409",
            description = "Email already blacklisted",
            content =
                @Content(
                    mediaType = "application/problem+json",
                    schema = @Schema(implementation = ProblemDetailResponse.class))),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content =
                @Content(
                    mediaType = "application/problem+json",
                    schema = @Schema(implementation = ProblemDetailResponse.class)))
      })
  @PostMapping
  public ResponseEntity<MessageResponse> addToBlacklist(
      @Valid @RequestBody BlacklistRequest request, HttpServletRequest httpServletRequest) {
    var response =
        blacklistService.addEmailToBlacklist(request, httpServletRequest.getRemoteAddr());
    return ResponseEntity.ok(response);
  }

  /**
   * Endpoint to check if an email is blacklisted.
   *
   * <p>This method validates the email format and returns the blacklist status for the specified
   * email. If the email is not present in the blacklist, a response indicating non-blacklisted
   * status is returned.
   *
   * @param email the email address to be checked, which must be a non-blank and valid email format.
   * @return a {@link ResponseEntity} encapsulating a {@link
   *     com.example.blacklistapi.application.dto.BlacklistResponse} representing the blacklist
   *     status of the email.
   */
  @Operation(
      summary = "Check if an email is blacklisted",
      description =
          "Validates the email format and returns a response indicating the blacklist status.")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Successfully fetched blacklist status",
            content =
                @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = BlacklistResponse.class))),
        @ApiResponse(
            responseCode = "401",
            description = "Unauthorized",
            content =
                @Content(
                    mediaType = "application/problem+json",
                    schema = @Schema(implementation = ProblemDetailResponse.class))),
        @ApiResponse(
            responseCode = "500",
            description = "Internal server error",
            content =
                @Content(
                    mediaType = "application/problem+json",
                    schema = @Schema(implementation = ProblemDetailResponse.class)))
      })
  @GetMapping("/{email}")
  public ResponseEntity<BlacklistResponse> checkBlacklist(
      @PathVariable
          @NotBlank(message = "Email cannot be blank")
          @Email(message = "Email is not valid")
          String email) {
    return ResponseEntity.ok(blacklistService.checkEmailBlackList(email));
  }
}
