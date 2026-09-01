package com.his.authservice.security;

import java.util.Set;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;

@Getter
public class CustomUserDetails implements UserDetails {
  private final UUID id;
  private final String username;
  private final String password;
  private final boolean enabled;
  private final String role;
  private final Set<String> permissions;
  private final Set<GrantedAuthority> authorities;

  public CustomUserDetails(
      UUID id,
      String username,
      String password,
      boolean enabled,
      String role,
      Set<String> permissions,
      Set<GrantedAuthority> authorities) {

    this.id = id;
    this.username = username;
    this.password = password;
    this.enabled = enabled;
    this.role = role;
    this.permissions = Set.copyOf(permissions);
    this.authorities = Set.copyOf(authorities);
  }
}
