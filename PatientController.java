package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final Map<Integer, String> patients = new HashMap<>();

    @GetMapping("/{id}")
    public ResponseEntity<String> getPatient(@PathVariable int id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        }
        String patient = patients.get(id);
        return patient != null ? ResponseEntity.ok(patient)
                               : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<String> addPatient(@RequestParam int id, @RequestParam String name) {
        // Input validation
        if (id <= 0) {
            return ResponseEntity.badRequest().body("Patient ID must be positive");
        }
        if (name == null || name.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Patient name cannot be empty");
        }
        if (patients.containsKey(id)) {
            return ResponseEntity.badRequest().body("Patient with ID " + id + " already exists");
        }
        
        patients.put(id, name);
        return ResponseEntity.ok("Patient added: " + name);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePatient(@PathVariable int id, @RequestParam String name) {
        // Input validation
        if (id <= 0) {
            return ResponseEntity.badRequest().body("Patient ID must be positive");
        }
        if (name == null || name.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Patient name cannot be empty");
        }
        if (!patients.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        
        patients.put(id, name);
        return ResponseEntity.ok("Patient updated: " + name);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable int id) {
        if (id <= 0) {
            return ResponseEntity.badRequest().build();
        }
        if (!patients.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }
        
        patients.remove(id);
        return ResponseEntity.ok("Patient with ID " + id + " deleted");
    }

    @GetMapping
    public ResponseEntity<Map<Integer, String>> getAllPatients() {
        return ResponseEntity.ok(patients);
    }
}