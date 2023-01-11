package com.example.vetclinicsystem.service;

import com.example.vetclinicsystem.model.MedicalCard;
import com.example.vetclinicsystem.repository.MedicalCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicalCardService {

    @Autowired
    private MedicalCardRepository medicalCardRepository;

    public MedicalCardService(MedicalCardRepository patientRepository) {
        this.medicalCardRepository = patientRepository;
    }

    public MedicalCard saveMedicalCard(MedicalCard medicalCard) {
        medicalCardRepository.save(medicalCard);
        return medicalCard;
    }

    public List<MedicalCard> findAll() {
        return medicalCardRepository.findAll();
    }

    public Optional<MedicalCard> findByUsername(String username) {
        return medicalCardRepository.findMedicalCardByPatientNickname(username);
    }
}
