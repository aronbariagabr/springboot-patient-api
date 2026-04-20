package com.aronbariagabr.patientapi.service;

import com.aronbariagabr.patientapi.model.Patient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PatientService {
    private final Map<Long, Patient> patients = new HashMap<>();

    public Patient addPatient(Patient patient) {
        patients.put(patient.getId(), patient);
        return patient;
    }

    public Patient getPatient(Long id) {
        return patients.get(id);
    }
}
