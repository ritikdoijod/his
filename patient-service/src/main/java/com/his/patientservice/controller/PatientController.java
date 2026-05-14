package com.his.patientservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.his.patientservice.dtos.PatientRequest;
import com.his.patientservice.dtos.PatientResponse;
import com.his.patientservice.service.PatientService;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/patients")
@AllArgsConstructor
public class PatientController {
    private final PatientService patientService;

    @PostMapping
    public PatientResponse createPatient(@RequestBody PatientRequest patientRequest) {
        return patientService.createPatient(patientRequest);
    }
    
}
