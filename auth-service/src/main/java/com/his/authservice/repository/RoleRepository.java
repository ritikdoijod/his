package com.his.authservice.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.his.authservice.model.Role;

public interface RoleRepository extends JpaRepository<Role, UUID> {
  Optional<Role> findByCode(String code);
  boolean existsByCode(String code);
}
