package com.his.authservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.authorization.OAuth2TokenType;
import org.springframework.security.oauth2.server.authorization.token.JwtEncodingContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenCustomizer;
import org.springframework.security.oauth2.server.authorization.client.JdbcRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;

import com.his.authservice.security.CustomUserDetails;

@Configuration
public class AuthorizationServerConfig {
    @Bean
    public RegisteredClientRepository registeredClientRepository(JdbcTemplate jdbcTemplate) {
        JdbcRegisteredClientRepository repository = new JdbcRegisteredClientRepository(jdbcTemplate);
        return repository;
    }

    @Bean
    OAuth2TokenCustomizer<JwtEncodingContext> accessTokenCustomizer() {
        return (context) -> {
          if (OAuth2TokenType.ACCESS_TOKEN.equals(context.getTokenType())) {
            Authentication authentication = context.getPrincipal();
            if (authentication.getPrincipal() instanceof CustomUserDetails user) {
              context.getClaims()
                  .claim("sub", user.getId().toString())
                  .claim("role", user.getRole())
                  .claim("permissions", user.getPermissions());
            }

          }
        };
    }
}
