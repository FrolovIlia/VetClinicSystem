package com.example.vetclinicsystem.repository;

import com.example.vetclinicsystem.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClientRepository extends MongoRepository<Client, String> {
    Optional<Client> findClientByClientFullName(String clientFullName);
}