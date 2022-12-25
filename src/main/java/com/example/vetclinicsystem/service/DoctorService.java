package com.example.vetclinicsystem.service;

import com.example.vetclinicsystem.model.Doctor;
import com.example.vetclinicsystem.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository userRepository;


    public void saveDoctor(Doctor doctor){
        userRepository.save(doctor);
    }

    public List<Doctor> findAll(){
        return userRepository.findAll();
    }
}
