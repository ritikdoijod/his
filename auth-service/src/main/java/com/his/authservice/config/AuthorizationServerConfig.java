package com.his.authservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.server.authorization.OAuth2TokenType;
import org.springframework.security.oauth2.server.authorization.token.JwtEncodingContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenCustomizer;

import com.his.authservice.security.CustomUserDetails;

@Configuration
public class AuthorizationServerConfig {
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
