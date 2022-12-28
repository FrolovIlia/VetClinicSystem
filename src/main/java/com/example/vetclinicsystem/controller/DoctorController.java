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

    @GetMapping(path = "/doctor/{username}")
    public Optional<Doctor> findById(@PathVariable("username") String username) {
        return userService.findByUsername(username);
    }

    @PostMapping(path = "/doctor/")
    public void post(@RequestBody Doctor doctor) {
        userService.saveDoctor(doctor);
    }

    //Добавить обновление - Update по ID

//    @PatchMapping(path = "/doctor/{doctorID}")
//    public Optional<Doctor> update(@PathVariable Integer doctorId, @RequestBody CreateUserRequest request) {
//        return userService.updateDoctor(userId, request);
//    }


    //Пример
//    @PatchMapping(value = "/{userId}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
//    public UserResponse update(@PathVariable Integer userId, @RequestBody CreateUserRequest request) {
//        return userService.update(userId, request);
//    }





    //Добавить удаление по ID

//    @DeleteMapping(path = "/doctor/{id}")
//    public void deleteDoctorCard(@PathVariable("id") String topicId) {
//        userService.deleteById(topicId);
//    }





//    @DeleteMapping(path = "topic/{id}")
//    public void deleteTopic(@PathVariable("id") String topicId) {
//        topicRepository.deleteById(topicId);
//    }




}

