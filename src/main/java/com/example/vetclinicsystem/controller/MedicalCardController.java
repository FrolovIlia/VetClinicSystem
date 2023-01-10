package com.example.vetclinicsystem.controller;

import com.example.vetclinicsystem.model.MedicalCard;
import com.example.vetclinicsystem.repository.MedicalCardRepository;
import com.example.vetclinicsystem.service.MedicalCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MedicalCardController {
    @Autowired
    private MedicalCardService medicalCardService;
    @Autowired
    private MedicalCardRepository patientRepository;

//    @GetMapping(path = "/patients")
//    public ResponseEntity<List<MedicalCard>> findAll() {
//        return ResponseEntity.ok(medicalCardService.findAll());
//    }
//
//    @GetMapping(path = "/patient/{username}")
//    public Optional<MedicalCard> findById(@PathVariable("username") String username) {
//        return medicalCardService.findByUsername(username);
//    }

//    @PostMapping(path = "/patient")
//    public MedicalCard post(@RequestBody MedicalCard patient) {
//        return patientService.savePatient(patient);
//    }
//
//    @PutMapping("/patients/{patientId}")
//    public ResponseEntity<MedicalCard> updatePatient(@PathVariable(value = "patientId") String patientId,
//                                                 @Valid @RequestBody MedicalCard newPatient) throws ResponseStatusException {
//        Patient patient = patientRepository.findById(patientId)
//                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find resource"));
//
//        patient.setPatientId(newPatient.getPatientId());
//        patient.setPatientNickname(newPatient.getPatientNickname());
//        patient.setColour(newPatient.getColour());
//        patient.setType(newPatient.getType());
//        patient.setAge(newPatient.getAge());
//        final MedicalCard updatedMedicalCard = patientRepository.save(patient);
//        return ResponseEntity.ok(updatedMedicalCard);
//    }
//
//
//    @DeleteMapping(path = "/patient/{id}")
//    public void deletePatient(@PathVariable("id") String patientId) {
//        patientRepository.deleteById(patientId);
//    }



}
