package com.his.patientservice.service;

import com.his.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import com.his.patientservice.dtos.PatientRequest;
import com.his.patientservice.dtos.PatientResponse;
import com.his.patientservice.exception.BadRequestException;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientResponse createPatient(PatientRequest patientRequest) {
        if (!patientRepository.existsByEmail(patientRequest.getEmail())) {
            throw new BadRequestException("Email already exists");
        }
        
        return null;
    }

}
