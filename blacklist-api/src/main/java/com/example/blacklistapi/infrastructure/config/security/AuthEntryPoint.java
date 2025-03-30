package com.example.blacklistapi.infrastructure.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * Authentication entry point implementation for handling unauthorized access.
 *
 * <p>This class intercepts authentication failures and builds a ProblemDetail response with HTTP
 * 401 status. It formats the response using an ObjectMapper configured to handle Java time types
 * and associate proper response parameters.
 */
public class AuthEntryPoint implements AuthenticationEntryPoint {

  private final ObjectMapper objectMapper;

  /**
   * Constructs a new AuthEntryPoint instance.
   *
   * <p>Initializes the ObjectMapper by registering the JavaTimeModule and disabling the
   * serialization of dates as timestamps.
   */
  public AuthEntryPoint() {
    this.objectMapper = new ObjectMapper();
    this.objectMapper.registerModule(new JavaTimeModule());
    this.objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
  }

  /**
   * Commences an authentication scheme.
   *
   * <p>This method is invoked when a user attempts to access a secured resource without proper
   * authentication. It builds a ProblemDetail response with a 401 Unauthorized status, a title set
   * to the status phrase, and a type identifier set to "about:blank", then writes the JSON
   * representation of the ProblemDetail to the response.
   *
   * @param request the HTTP request that resulted in an AuthenticationException
   * @param response the HTTP response, to which the ProblemDetail will be written
   * @param authException the exception that caused the invocation
   * @throws IOException if an input or output error occurs during writing the response
   * @throws ServletException if the request could not be handled
   */
  @Override
  public void commence(
      HttpServletRequest request,
      HttpServletResponse response,
      AuthenticationException authException)
      throws IOException, ServletException {

    // Build a ProblemDetail with HTTP 401 status and error details from the exception.
    ProblemDetail pd =
        ProblemDetail.forStatusAndDetail(
            HttpStatus.UNAUTHORIZED,
            authException.getMessage() != null
                ? authException.getMessage()
                : "Unauthorized access");
    // Set the title to the standard HTTP status phrase.
    pd.setTitle(HttpStatus.UNAUTHORIZED.getReasonPhrase());
    // Set type to a generic "about:blank" URI, indicating no specific error type.
    pd.setType(URI.create("about:blank"));

    // Set the response status, content type, and write the ProblemDetail JSON.
    response.setStatus(HttpStatus.UNAUTHORIZED.value());
    response.setContentType("application/problem+json");
    objectMapper.writeValue(response.getOutputStream(), pd);
  }
}
