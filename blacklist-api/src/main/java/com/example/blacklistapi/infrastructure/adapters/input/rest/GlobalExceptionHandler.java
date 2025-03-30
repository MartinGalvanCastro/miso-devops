package com.example.blacklistapi.infrastructure.adapters.input.rest;

import com.example.blacklistapi.domain.exception.ApiException;
import com.example.blacklistapi.domain.exception.EmailBlacklistedException;
import com.example.blacklistapi.domain.exception.NotAuthorizedException;
import jakarta.validation.ConstraintViolationException;
import java.net.URI;
import java.util.stream.Collectors;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler to manage and format errors across the REST API.
 *
 * <p>This controller advice intercepts exceptions thrown by REST controllers and returns a
 * standardized {@code ProblemDetail} response conforming to application-specific error handling.
 * Common exceptions such as validation errors, API exceptions, and generic exceptions are handled
 * here.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

  /**
   * Handles exceptions arising from invalid method arguments.
   *
   * <p>Generates a {@code ProblemDetail} with details from the field errors extracted from the
   * binding result of the exception.
   *
   * @param ex the {@code MethodArgumentNotValidException} instance containing validation errors
   * @return a {@code ProblemDetail} object configured with status, title, and detailed error
   *     messages
   */
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ProblemDetail handleValidationExceptions(MethodArgumentNotValidException ex) {
    String details =
        ex.getBindingResult().getFieldErrors().stream()
            .map(error -> error.getField() + ": " + error.getDefaultMessage())
            .collect(Collectors.joining(", "));
    ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, details);
    // When using "about:blank", the title is typically the standard status phrase.
    pd.setTitle(HttpStatus.BAD_REQUEST.getReasonPhrase());
    pd.setType(URI.create("about:blank"));
    return pd;
  }

  /**
   * Handles exceptions related to constraint violations.
   *
   * <p>This method collects all constraint violation messages and returns a {@code ProblemDetail}
   * with a BAD REQUEST status containing the aggregated error details.
   *
   * @param ex the {@code ConstraintViolationException} instance containing violation details
   * @return a {@code ProblemDetail} object configured with appropriate status and detailed error
   *     message
   */
  @ExceptionHandler(ConstraintViolationException.class)
  public ProblemDetail handleConstraintViolationException(ConstraintViolationException ex) {
    String details =
        ex.getConstraintViolations().stream()
            .map(cv -> cv.getPropertyPath() + ": " + cv.getMessage())
            .collect(Collectors.joining(", "));
    ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, details);
    pd.setTitle(HttpStatus.BAD_REQUEST.getReasonPhrase());
    pd.setType(URI.create("about:blank"));
    return pd;
  }

  /**
   * Handles specific API exceptions, namely {@code EmailBlacklistedException} and {@code
   * NotAuthorizedException}.
   *
   * <p>This method sets the response status to CONFLICT for email blacklist issues, or UNAUTHORIZED
   * for authorization issues, and includes an error message.
   *
   * @param ex the {@code ApiException} instance which is either an {@code
   *     EmailBlacklistedException} or {@code NotAuthorizedException}
   * @return a {@code ProblemDetail} configured with the specific HTTP status and detailed error
   *     message
   */
  @ExceptionHandler({EmailBlacklistedException.class, NotAuthorizedException.class})
  public ProblemDetail handleSpecificExceptions(ApiException ex) {
    HttpStatus status =
        ex instanceof EmailBlacklistedException ? HttpStatus.CONFLICT : HttpStatus.UNAUTHORIZED;
    ProblemDetail pd =
        ProblemDetail.forStatusAndDetail(
            status, ex.getReason() != null ? ex.getReason() : ex.getMessage());
    pd.setTitle(status.getReasonPhrase());
    pd.setType(URI.create("about:blank"));
    return pd;
  }

  /**
   * Handles generic API exceptions resulting from business logic errors.
   *
   * <p>This method returns a BAD REQUEST status along with the error message provided by the
   * exception.
   *
   * @param ex the {@code ApiException} instance containing error details
   * @return a {@code ProblemDetail} object with BAD REQUEST status and a detailed error message
   */
  @ExceptionHandler(ApiException.class)
  public ProblemDetail handleApiException(ApiException ex) {
    ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
    pd.setTitle(HttpStatus.BAD_REQUEST.getReasonPhrase());
    pd.setType(URI.create("about:blank"));
    return pd;
  }

  /**
   * Handles all other exceptions not specifically handled by other methods.
   *
   * <p>This catch-all exception handler returns an INTERNAL SERVER ERROR status along with the
   * exception message to indicate an unexpected error.
   *
   * @param ex the {@code Exception} instance that was thrown
   * @return a {@code ProblemDetail} configured with INTERNAL SERVER ERROR status and a detailed
   *     error message
   */
  @ExceptionHandler(Exception.class)
  public ProblemDetail handleGenericException(Exception ex) {
    ProblemDetail pd =
        ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    pd.setTitle(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    pd.setType(URI.create("about:blank"));
    return pd;
  }

  /**
   * Handles validation errors for method parameters detected by the framework.
   *
   * <p>This method aggregates validation errors from method parameters (e.g., via @Validated on a
   * controller method) and returns a ProblemDetail with a BAD REQUEST status, using the default
   * HTTP reason phrase as the title. The detail field contains a comma-separated list of parameter
   * names and their corresponding error messages.
   *
   * @param ex the HandlerMethodValidationException containing parameter validation errors
   * @return a ProblemDetail configured with a 400 status and the aggregated error messages
   */
  @ExceptionHandler(
      org.springframework.web.method.annotation.HandlerMethodValidationException.class)
  public ProblemDetail handleHandlerMethodValidationException(
      org.springframework.web.method.annotation.HandlerMethodValidationException ex) {
    String details =
        ex.getParameterValidationResults().stream()
            .map(
                error -> {
                  String paramName = error.getMethodParameter().getParameterName();
                  String messages =
                      error.getResolvableErrors().stream()
                          .map(MessageSourceResolvable::getDefaultMessage)
                          .collect(Collectors.joining(", "));
                  return (paramName != null ? paramName : "parameter") + ": " + messages;
                })
            .collect(Collectors.joining(", "));
    ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, details);
    pd.setTitle(HttpStatus.BAD_REQUEST.getReasonPhrase());
    pd.setType(URI.create("about:blank"));
    return pd;
  }
}
