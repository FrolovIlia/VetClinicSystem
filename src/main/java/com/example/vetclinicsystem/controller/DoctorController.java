package com.example.vetclinicsystem.controller;

import com.example.vetclinicsystem.model.Doctor;
import com.example.vetclinicsystem.repository.DoctorRepository;
import com.example.vetclinicsystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping(path = "/doctors")
    public ResponseEntity<List<Doctor>> findAll() {
        return ResponseEntity.ok(doctorService.findAll());
    }

    @GetMapping(path = "/doctor/{username}")
    public Optional<Doctor> findById(@PathVariable("username") String username) {
        return doctorService.findByUsername(username);
    }

    @PostMapping(path = "/doctor")
    public Doctor post(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }

    @PatchMapping("/doctor/{doctorId}/{doctorFullName}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable String doctorId, @PathVariable String doctorFullName) {
        try {
            Doctor doctor = doctorRepository.findById(doctorId).get();
            doctor.setDoctorFullName(doctorFullName);
            return new ResponseEntity<Doctor>(doctorRepository.save(doctor), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/doctor/{id}")
    public void deleteDoctor(@PathVariable("id") String doctorId) {
        doctorRepository.deleteById(doctorId);
    }

}

