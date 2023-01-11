package com.example.vetclinicsystem.repository;

import com.example.vetclinicsystem.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository extends MongoRepository<Doctor, String> {
    Optional<Doctor> findDoctorByDoctorFullName(String doctorFullName);
}
