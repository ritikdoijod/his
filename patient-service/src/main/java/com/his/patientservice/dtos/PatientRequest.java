package com.his.patientservice.dtos;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PatientRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;
}
