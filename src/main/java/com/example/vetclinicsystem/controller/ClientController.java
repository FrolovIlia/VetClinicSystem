package com.example.vetclinicsystem.controller;

import com.example.vetclinicsystem.model.Client;
import com.example.vetclinicsystem.model.Doctor;
import com.example.vetclinicsystem.repository.ClientRepository;
import com.example.vetclinicsystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;


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

//    @PutMapping("/clients/{clientId}")
//    Client replaceClient(@RequestBody Client newClient, @PathVariable String clientId) {
//
//        return clientRepository.findById(clientId)
//                .map(client -> {
//                    client.setClientFullName(newClient.getClientFullName());
//                    return clientRepository.save(client);
//                })
//                .orElseGet(() -> {
//                    newClient.setClientId(clientId);
//                    return clientRepository.save(newClient);
//                });
//    }


    @PutMapping("/clients/{clientId}")
    public ResponseEntity<Client> updateClient(@PathVariable(value = "clientId") String clientId,
                                               @Valid @RequestBody Client newClient) throws ResponseStatusException {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find resource"));

        client.setClientId(newClient.getClientId());
        client.setClientFullName(newClient.getClientFullName());

        final Client updatedClient = clientRepository.save(client);
        return ResponseEntity.ok(updatedClient);
    }


    @DeleteMapping(path = "/client/{id}")
    public void deleteClient(@PathVariable("id") String clientId) {
        clientRepository.deleteById(clientId);
    }

}

