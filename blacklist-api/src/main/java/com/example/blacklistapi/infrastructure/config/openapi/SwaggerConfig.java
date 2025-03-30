package com.example.blacklistapi.infrastructure.config.openapi;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(
            new Info()
                .title("Blacklist API")
                .version("1.0")
                .description("API for managing blacklisted emails")
                .contact(new Contact().name("Support").email("support@example.com")))
        .components(
            new Components()
                .addSecuritySchemes(
                    "bearerAuth",
                    new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")
                        .description("Static token authorization")));
  }

  @Bean
  public GroupedOpenApi publicApi() {
    return GroupedOpenApi.builder().group("blacklist").pathsToMatch("/v1/blacklist/**").build();
  }
}
