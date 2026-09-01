package com.his.authservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.his.authservice.model.Permission;
import java.util.Optional;

public interface PermissionRepository extends JpaRepository<Permission, UUID> {
  Optional<Permission> findByCode(String code);
  boolean existsByCode(String code);
}
