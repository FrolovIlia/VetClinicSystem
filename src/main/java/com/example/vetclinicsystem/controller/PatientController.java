package com.example.vetclinicsystem.controller;

import com.example.vetclinicsystem.model.Patient;
import com.example.vetclinicsystem.repository.PatientRepository;
import com.example.vetclinicsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping(path = "/patients")
    public ResponseEntity<List<Patient>> findAll() {
        return ResponseEntity.ok(patientService.findAll());
    }

    @GetMapping(path = "/patient/{username}")
    public Optional<Patient> findById(@PathVariable("username") String username) {
        return patientService.findByUsername(username);
    }

    @PostMapping(path = "/patient")
    public Patient post(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    // Разобраться с множественным обновлением
    @PatchMapping("/patient/{patientId}/{patientNickname}/{colour}/{type}/{age}")
    public ResponseEntity<Patient> updatePatient(@PathVariable String patientId,
                                                 @PathVariable String patientNickname,
                                                 @PathVariable String colour,
                                                 @PathVariable String type,
                                                 @PathVariable String age) {
        try {
            Patient patient = patientRepository.findById(patientId).get();
            patient.setPatientNickname(patientNickname);
            patient.setPatientNickname(colour);
            patient.setPatientNickname(type);
            patient.setPatientNickname(age);
            return new ResponseEntity<>(patientRepository.save(patient), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/patient/{id}")
    public void deletePatient(@PathVariable("id") String patientId) {
        patientRepository.deleteById(patientId);
    }
}













