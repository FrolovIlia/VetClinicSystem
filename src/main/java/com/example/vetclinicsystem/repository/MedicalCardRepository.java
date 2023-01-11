package com.example.vetclinicsystem.repository;

import com.example.vetclinicsystem.model.MedicalCard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicalCardRepository extends MongoRepository<MedicalCard, String> {
    Optional<MedicalCard> findMedicalCardByPatientNickname(String patientNickname);
}
