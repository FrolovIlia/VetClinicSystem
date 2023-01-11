package com.example.vetclinicsystem.controller;

import com.example.vetclinicsystem.model.MedicalCard;
import com.example.vetclinicsystem.repository.MedicalCardRepository;
import com.example.vetclinicsystem.service.MedicalCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class MedicalCardController {
    @Autowired
    private MedicalCardService medicalCardService;
    @Autowired
    private MedicalCardRepository medicalCardRepository;

    @GetMapping(path = "/medicalCards")
    public ResponseEntity<List<MedicalCard>> findAll() {
        return ResponseEntity.ok(medicalCardService.findAll());
    }

    @GetMapping(path = "/medicalCard/{username}")
    public Optional<MedicalCard> findById(@PathVariable("username") String username) {
        return medicalCardService.findByUsername(username);
    }

    @PostMapping(path = "/medicalCard")
    public MedicalCard post(@RequestBody MedicalCard medicalCard) {
        return medicalCardService.saveMedicalCard(medicalCard);
    }

    @PutMapping("/medicalCards/{medicalCardId}")
    public ResponseEntity<MedicalCard> updateMedicalCard(@PathVariable(value = "medicalCardId") String medicalCardId,
                                                 @Valid @RequestBody MedicalCard newMedicalCard) throws ResponseStatusException {
        MedicalCard medicalCard = medicalCardRepository.findById(medicalCardId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find resource"));

        medicalCard.setMedicalCardId(newMedicalCard.getMedicalCardId());
        medicalCard.setPatientNickname(newMedicalCard.getPatientNickname());
        medicalCard.setProblem(newMedicalCard.getProblem());
        medicalCard.setBio(newMedicalCard.getBio());
        final MedicalCard updatedMedicalCard = medicalCardRepository.save(medicalCard);
        return ResponseEntity.ok(updatedMedicalCard);
    }

    @DeleteMapping(path = "/medicalCard/{id}")
    public void deleteMedicalCard(@PathVariable("id") String medicalCardId) {
        medicalCardRepository.deleteById(medicalCardId);
    }



}
