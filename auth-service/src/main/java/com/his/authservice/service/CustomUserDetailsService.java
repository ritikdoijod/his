package com.his.authservice.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.his.authservice.model.User;
import com.his.authservice.repository.UserRepository;
import com.his.authservice.security.CustomUserDetails;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
  public final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));

    Set<GrantedAuthority> authorities = new HashSet<>();
    Set<String> permissions = new HashSet<>();

    authorities.add(new SimpleGrantedAuthority(user.getRole().getCode()));

    user.getRole().getPermissions()
        .forEach(permission -> {
          authorities.add(new SimpleGrantedAuthority(permission.getCode()));
          permissions.add(permission.getCode());
        });

    return new CustomUserDetails(user.getId(), user.getUsername(), user.getPassword(), user.getEnabled(),
        user.getRole().getCode(), permissions, authorities);
  }

}