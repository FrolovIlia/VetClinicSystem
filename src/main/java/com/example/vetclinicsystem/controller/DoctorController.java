package com.example.vetclinicsystem.controller;

import com.example.vetclinicsystem.model.Doctor;
import com.example.vetclinicsystem.repository.DoctorRepository;
import com.example.vetclinicsystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;


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
    public ResponseEntity<Doctor> updateDoctor(@PathVariable(value = "doctorId") String doctorId,
                                                 @Valid @RequestBody Doctor newDoctor) throws ResponseStatusException {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find resource"));

        doctor.setDoctorId(newDoctor.getDoctorId());
        doctor.setDoctorFullName(newDoctor.getDoctorFullName());

        final Doctor updatedDoctor = doctorRepository.save(doctor);
        return ResponseEntity.ok(updatedDoctor);
    }

    @DeleteMapping(path = "/doctor/{id}")
    public void deleteDoctor(@PathVariable("id") String doctorId) {
        doctorRepository.deleteById(doctorId);
    }
}

