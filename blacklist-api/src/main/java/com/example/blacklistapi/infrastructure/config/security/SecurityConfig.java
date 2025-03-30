package com.example.blacklistapi.infrastructure.config.security;

import java.time.Instant;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security configuration class for the application.
 *
 * <p>This class sets up the HTTP security filter chain, disables CSRF, defines endpoint
 * authorization, and configures the OAuth2 resource server with a custom JWT decoder and
 * authentication entry point.
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  /** The static token used for authenticating requests to secure endpoints. */
  @Value("${security.static-token}")
  private String staticToken;

  /**
   * Configures the HTTP security filter chain.
   *
   * <p>Disables CSRF, requires authentication for requests to {@code /v1/blacklist/**}, and permits
   * all other requests. Configures the OAuth2 resource server to use a custom JWT decoder and a
   * custom authentication entry point.
   *
   * @param http the HttpSecurity object to configure
   * @return the configured SecurityFilterChain
   * @throws Exception if an error occurs during configuration
   */
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(
            auth ->
                auth.requestMatchers("/v1/blacklist/**").authenticated().anyRequest().permitAll())
        .oauth2ResourceServer(
            oauth2 ->
                oauth2
                    .jwt(jwt -> jwt.decoder(staticTokenJwtDecoder()))
                    .authenticationEntryPoint(new AuthEntryPoint()));

    return http.build();
  }

  /**
   * Creates a custom {@code JwtDecoder} that validates the JWT against a static token.
   *
   * <p>Checks if the provided token matches the configured static token. If it doesn't match, a
   * {@link BadCredentialsException} is thrown. Otherwise, a {@link Jwt} object is created with a
   * default expiration time.
   *
   * @return the custom JwtDecoder
   */
  private JwtDecoder staticTokenJwtDecoder() {
    return token -> {
      if (!token.equals(staticToken)) {
        throw new BadCredentialsException("Token is invalid");
      }
      return new Jwt(
          token,
          Instant.now(),
          Instant.now().plusSeconds(3600),
          Map.of("alg", "none"),
          Map.of("sub", "api-user"));
    };
  }
}
