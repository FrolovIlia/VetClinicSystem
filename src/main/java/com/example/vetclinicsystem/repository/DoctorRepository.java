package com.example.vetclinicsystem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DoctorRepository<User> extends MongoRepository<User, String> {
    Optional<User> findUserByUsername(String username);
}
