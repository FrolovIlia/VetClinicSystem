package com.example.vetclinicsystem.repository;

import com.example.vetclinicsystem.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {
    Optional<Patient> findPatientByPatientNickname(String patientNickname);
}
