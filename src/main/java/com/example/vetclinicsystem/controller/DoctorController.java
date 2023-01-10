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
    public Optional<Doctor> findByDoctorName(@PathVariable("username") String username) {
        return doctorService.findByUsername(username);
    }


    @PostMapping(path = "/doctor")
    public Doctor post(@RequestBody Doctor doctor) {
        return doctorService.saveDoctor(doctor);
    }


    @PutMapping("/doctors/{doctorId}")
    Doctor replaceDoctor(@RequestBody Doctor newDoctor, @PathVariable String doctorId) {

        return doctorRepository.findById(doctorId)
                .map(doctor -> {
                    doctor.setDoctorFullName(newDoctor.getDoctorFullName());
                    return doctorRepository.save(doctor);
                })
                .orElseGet(() -> {
                    newDoctor.setDoctorId(doctorId);
                    return doctorRepository.save(newDoctor);
                });
    }

    @DeleteMapping(path = "/doctor/{id}")
    public void deleteDoctor(@PathVariable("id") String doctorId) {
        doctorRepository.deleteById(doctorId);
    }
}

