package com.his.patientservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.his.patientservice.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
    boolean existsByEmail(String email);
}
