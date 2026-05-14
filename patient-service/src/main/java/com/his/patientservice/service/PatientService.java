package com.his.patientservice.service;

import com.his.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import com.his.patientservice.dtos.PatientRequest;
import com.his.patientservice.dtos.PatientResponse;
import com.his.patientservice.exception.BadRequestException;
import com.his.patientservice.mapper.PatientMapper;
import com.his.patientservice.model.Patient;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientResponse createPatient(PatientRequest patientRequest) {
        if (patientRepository.existsByEmail(patientRequest.getEmail())) {
            throw new BadRequestException("Email already exists");
        }

        Patient newPatient = patientRepository.save(PatientMapper.toModel(patientRequest));
        
        return PatientMapper.toDTO(newPatient);
    }

}
