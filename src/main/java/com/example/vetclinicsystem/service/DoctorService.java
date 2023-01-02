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
    private DoctorRepository userRepository;


    public Doctor saveDoctor(Doctor doctor){
        userRepository.save(doctor);
        return doctor;
    }

    public List<Doctor> findAll(){
        return userRepository.findAll();
    }

    public Optional<Doctor> findByUsername(String username){
        return userRepository.findDoctorByDoctorFullName(username);
    }

    public void deleteDoctors() {
        userRepository.deleteAll();
    }

//    public Optional<Doctor> updateDoctor(String doctorId, String doctorFullName) {
//        return null;
//    }
}
