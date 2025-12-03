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
        String patient = patients.get(id);
        return patient != null ? ResponseEntity.ok(patient)
                               : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<String> addPatient(@RequestParam int id, @RequestParam String name) {
        patients.put(id, name);
        return ResponseEntity.ok("Patient added: " + name);
    }
}
