package com.his.patientservice.mapper;

import com.his.patientservice.dtos.PatientRequest;
import com.his.patientservice.dtos.PatientResponse;
import com.his.patientservice.model.Patient;

public class PatientMapper {

    public static PatientResponse toDTO(Patient patient) {
        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setId(patient.getId());
        patientResponse.setFirstName(patient.getFirstName());
        patientResponse.setLastName(patient.getLastName());
        patientResponse.setEmail(patient.getEmail());
        patientResponse.setPhoneNumber(patient.getPhoneNumber());
        patientResponse.setDateOfBirth(patient.getDateOfBirth());
        patientResponse.setCreatedAt(patient.getCreatedAt());
        patientResponse.setUpdatedAt(patient.getUpdatedAt());
        return patientResponse;
    }

    public static Patient toModel(PatientRequest patientRequest) {
        Patient patient = new Patient();
        patient.setFirstName(patientRequest.getFirstName());
        patient.setLastName(patientRequest.getLastName());
        patient.setEmail(patientRequest.getEmail());
        patient.setPhoneNumber(patientRequest.getPhoneNumber());
        patient.setDateOfBirth(patientRequest.getDateOfBirth());
        return patient;
    }

}
