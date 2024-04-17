package org.fastgym.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI fastGymOpenApi() {
        var openApi = new OpenAPI();
        openApi
                .info(new Info().title("FAST GYM API")
                        .description(
                                "FAST GYM REST API documentation.")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0").url("https://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("FAST GYM Wiki Documentation")
                        .url("https://fast-gym.wiki.github.org/docs"));
        return openApi;
    }
}