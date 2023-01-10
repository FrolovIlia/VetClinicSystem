package com.example.vetclinicsystem.controller;

import com.example.vetclinicsystem.model.Patient;
import com.example.vetclinicsystem.repository.PatientRepository;
import com.example.vetclinicsystem.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping(path = "/patients")
    public ResponseEntity<List<Patient>> findAll() {
        return ResponseEntity.ok(patientService.findAll());
    }

    @GetMapping(path = "/patient/{username}")
    public Optional<Patient> findById(@PathVariable("username") String username) {
        return patientService.findByUsername(username);
    }

    @PostMapping(path = "/patient")
    public Patient post(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

//    @PutMapping("/employees/{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
//                                                   @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
//        Employee employee = employeeRepository.findById(employeeId)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
//
//        employee.setEmailId(employeeDetails.getEmailId());
//        employee.setLastName(employeeDetails.getLastName());
//        employee.setFirstName(employeeDetails.getFirstName());
//        final Employee updatedEmployee = employeeRepository.save(employee);
//        return ResponseEntity.ok(updatedEmployee);
//    }

    // Разобраться с PUT
    @PutMapping("/patients/{patientId}")
    Patient replacePatient(@RequestBody Patient newPatient,
                           @PathVariable String patientId,
                           @PathVariable String patientNickname,
                           @PathVariable String colour,
                           @PathVariable String type,
                           @PathVariable int age) {

        return patientRepository.findById(patientId)
                .map(patient -> {
                    patient.setPatientId(newPatient.getPatientId());
                    patient.setPatientNickname(newPatient.getPatientNickname());
                    patient.setColour(newPatient.getColour());
                    patient.setType(newPatient.getType());
                    patient.setAge(newPatient.getAge());
                    return patientRepository.save(patient);
                })
                .orElseGet(() -> {
                    newPatient.setPatientId(patientId);
                    newPatient.setPatientNickname(patientNickname);
                    newPatient.setColour(colour);
                    newPatient.setType(type);
                    newPatient.setAge(age);
                    return patientRepository.save(newPatient);
                });
    }

    @DeleteMapping(path = "/patient/{id}")
    public void deletePatient(@PathVariable("id") String patientId) {
        patientRepository.deleteById(patientId);
    }
}













