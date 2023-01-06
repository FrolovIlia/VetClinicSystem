package com.example.vetclinicsystem.controller;

import com.example.vetclinicsystem.model.Client;
import com.example.vetclinicsystem.repository.ClientRepository;
import com.example.vetclinicsystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(path = "/clients")
    public ResponseEntity<List<Client>> findAll() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping(path = "/client/{username}")
    public Optional<Client> findById(@PathVariable("username") String username) {
        return clientService.findByUsername(username);
    }

    @PostMapping(path = "/client")
    public Client post(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    @PatchMapping("/client/{clientId}/{clientFullName}")
    public ResponseEntity<Client> updateClient(@PathVariable String clientId, @PathVariable String clientFullName) {
        try {
            Client client = clientRepository.findById(clientId).get();
            client.setClientFullName(clientFullName);
            return new ResponseEntity<Client>(clientRepository.save(client), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/client/{id}")
    public void deleteClient(@PathVariable("id") String clientId) {
        clientRepository.deleteById(clientId);
    }

}

