package com.example.vetclinicsystem.controller;

import com.example.vetclinicsystem.model.Patient;
import com.example.vetclinicsystem.repository.PatientRepository;
import com.example.vetclinicsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

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

    @PutMapping("/patients/{patientId}")
    public ResponseEntity<Patient> updatePatient(@PathVariable(value = "patientId") String patientId,
                                                   @Valid @RequestBody Patient newPatient) throws ResponseStatusException {
            Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find resource"));

        patient.setPatientId(newPatient.getPatientId());
        patient.setPatientNickname(newPatient.getPatientNickname());
        patient.setColour(newPatient.getColour());
        patient.setType(newPatient.getType());
        patient.setAge(newPatient.getAge());
        final Patient updatedPatient = patientRepository.save(patient);
        return ResponseEntity.ok(updatedPatient);
    }


    @DeleteMapping(path = "/patient/{id}")
    public void deletePatient(@PathVariable("id") String patientId) {
        patientRepository.deleteById(patientId);
    }
}













