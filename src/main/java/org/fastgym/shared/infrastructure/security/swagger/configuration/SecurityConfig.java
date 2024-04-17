package org.fastgym.shared.infrastructure.security.swagger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                //.csrf().disable() // Disable CSRF for now (consider enabling for production)
                .authorizeRequests()
                    //.antMatchers("/swagger-ui.html", "/swagger-resources/**", "/v3/api-docs/**") // Add Swagger UI related paths
                    //.access("permitAll()") // Allow access to these paths without authentication
                    .anyRequest()
                    //.authenticated() // Require authentication for other endpoints
                .anonymous();
        return http.build();
    }
}
