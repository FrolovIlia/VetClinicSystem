package com.example.vetclinicsystem.service;

import com.example.vetclinicsystem.model.Client;
import com.example.vetclinicsystem.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client saveClient(Client client) {
        return client;
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Optional<Client> findByUsername(String username) {
        return clientRepository.findClientByClientFullName(username);
    }
}
