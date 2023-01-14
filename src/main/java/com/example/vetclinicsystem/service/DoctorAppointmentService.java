package com.example.vetclinicsystem.service;

import com.example.vetclinicsystem.model.DoctorAppointment;
import com.example.vetclinicsystem.repository.DoctorAppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorAppointmentService {

    @Autowired
    private DoctorAppointmentRepository doctorAppointmentRepository;

    public DoctorAppointment saveDoctorAppointment(DoctorAppointment doctorAppointment) {
        doctorAppointmentRepository.save(doctorAppointment);
        return doctorAppointment;
    }

    public List<DoctorAppointment> findAll() {
        return doctorAppointmentRepository.findAll();
    }

    public Optional<DoctorAppointment> findByUsername(String username) {
        return doctorAppointmentRepository.findDoctorAppointmentByClientFullName(username);
    }
}
