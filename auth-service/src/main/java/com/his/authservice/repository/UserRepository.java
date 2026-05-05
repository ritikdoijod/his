package com.his.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.his.authservice.model.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
