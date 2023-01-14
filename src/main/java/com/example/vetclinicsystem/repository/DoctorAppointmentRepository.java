package com.example.vetclinicsystem.repository;

import com.example.vetclinicsystem.model.DoctorAppointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorAppointmentRepository extends MongoRepository<DoctorAppointment, String> {
    Optional<DoctorAppointment> findDoctorAppointmentByClientFullName(String clientFullName);
}