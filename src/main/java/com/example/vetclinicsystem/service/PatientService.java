package com.example.vetclinicsystem.service;

import com.example.vetclinicsystem.model.Patient;
import com.example.vetclinicsystem.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient savePatient(Patient patient) {
        patientRepository.save(patient);
        return patient;
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public Optional<Patient> findByUsername(String username) {
        return patientRepository.findPatientByPatientNickname(username);
    }
}
