package com.his.authservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.MediaTypeRequestMatcher;

@Configuration
public class SecurityConfig {
  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  @Order(1)
  SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.oauth2AuthorizationServer((authorizationServer) -> {
      httpSecurity.securityMatcher(authorizationServer.getEndpointsMatcher());
      authorizationServer.oidc(Customizer.withDefaults());
    }).authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated()).exceptionHandling(
        exceptions -> exceptions.defaultAuthenticationEntryPointFor(new LoginUrlAuthenticationEntryPoint("/login"),
            new MediaTypeRequestMatcher(MediaType.TEXT_HTML)));

    return httpSecurity.build();
  }

  @Bean
  @Order(2)
  SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.authorizeHttpRequests(
        authorize -> authorize.requestMatchers("/login", "/css/**", "/js/**").permitAll().anyRequest().authenticated())
        .formLogin(form -> form.loginPage("/login").permitAll());

    return httpSecurity.build();
  }
}
