package com.aronbariagabr.patientapi.controller;

import com.aronbariagabr.patientapi.model.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final Map<Long, Patient> patients = new HashMap<>();

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient) {
        patients.put(patient.getId(), patient);
        return patient;
    }

    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable Long id) {
        return patients.get(id);
    }
}
