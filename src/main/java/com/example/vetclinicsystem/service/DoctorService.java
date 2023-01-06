package com.example.vetclinicsystem.service;

import com.example.vetclinicsystem.model.Doctor;
import com.example.vetclinicsystem.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor saveDoctor(Doctor doctor){
        doctorRepository.save(doctor);
        return doctor;
    }

    public List<Doctor> findAll(){
        return doctorRepository.findAll();
    }

    public Optional<Doctor> findByUsername(String username){
        return doctorRepository.findDoctorByDoctorFullName(username);
    }

//    public void deleteDoctors() {
//        doctorRepository.deleteAll();
//    }

//    public Optional<Doctor> updateDoctor(String doctorId, String doctorFullName) {
//        return null;
//    }
}
