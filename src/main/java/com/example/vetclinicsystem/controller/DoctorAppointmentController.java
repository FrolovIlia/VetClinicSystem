package com.example.vetclinicsystem.controller;

import com.example.vetclinicsystem.model.DoctorAppointment;
import com.example.vetclinicsystem.repository.DoctorAppointmentRepository;
import com.example.vetclinicsystem.service.DoctorAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class DoctorAppointmentController {
    @Autowired
    private DoctorAppointmentService doctorAppointmentService;
    @Autowired
    private DoctorAppointmentRepository doctorAppointmentRepository;

    @GetMapping(path = "/doctorAppointment")
    public ResponseEntity<List<DoctorAppointment>> findAll() {
        return ResponseEntity.ok(doctorAppointmentService.findAll());
    }

    @GetMapping(path = "/doctorAppointment/{username}")
    public Optional<DoctorAppointment> findById(@PathVariable("username") String username) {
        return doctorAppointmentService.findByUsername(username);
    }

    @PostMapping(path = "/doctorAppointment")
    public DoctorAppointment post(@RequestBody DoctorAppointment doctorAppointment) {
        return doctorAppointmentService.saveDoctorAppointment(doctorAppointment);
    }

    @PutMapping("/doctorAppointments/{appointmentId}")
    public ResponseEntity<DoctorAppointment> updateDoctorAppointment(@PathVariable(value = "appointmentId") String appointmentIdId,
                                                         @Valid @RequestBody DoctorAppointment newDoctorAppointment) throws ResponseStatusException {
        DoctorAppointment doctorAppointment = doctorAppointmentRepository.findById(appointmentIdId)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find resource"));
        doctorAppointment.setAppointmentId(newDoctorAppointment.getAppointmentId());
        doctorAppointment.setDoctorFullName(newDoctorAppointment.getDoctorFullName());
        doctorAppointment.setClientFullName(newDoctorAppointment.getClientFullName());
        doctorAppointment.setPatientNickname(newDoctorAppointment.getPatientNickname());
        doctorAppointment.setProblem(newDoctorAppointment.getProblem());
        doctorAppointment.setBio(newDoctorAppointment.getBio());
        doctorAppointment.setStartTime(newDoctorAppointment.getStartTime());
        doctorAppointment.setEndTime(newDoctorAppointment.getEndTime());
//        doctorAppointment.setScheduled(newDoctorAppointment.getScheduled());
        final DoctorAppointment updatedDoctorAppointment = doctorAppointmentRepository.save(doctorAppointment);
        return ResponseEntity.ok(updatedDoctorAppointment);
    }

    @DeleteMapping(path = "/doctorAppointment/{appointmentId}")
    public void deleteDoctorAppointment(@PathVariable("appointmentId") String appointmentId) {
        doctorAppointmentRepository.deleteById(appointmentId);
    }



}
