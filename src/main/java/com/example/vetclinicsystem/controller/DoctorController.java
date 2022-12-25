package com.example.vetclinicsystem.controller;

import com.example.vetclinicsystem.model.Doctor;
import com.example.vetclinicsystem.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class DoctorController {
    @Autowired
    private DoctorService userService;

    @GetMapping(path = "/doctor/")
    public ResponseEntity<List<Doctor>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

//    Довести до ума ету штуку
//    @GetMapping(path = "/doctor/{username}")
//    public Optional<Doctor> findById(@PathVariable("username") String username) {
//        return userService.findByUsername(username);
//    }

    @PostMapping(path = "/doctor/")
    public void post(@RequestBody Doctor doctor) {
        userService.saveDoctor(doctor);
    }

    //Добавить обновление - Update по ID

}

