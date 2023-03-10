package com.example.vetclinicsystem.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;


@Data
public class DoctorAppointment {
    @Id
    private String appointmentId;
    private String doctorFullName;
    private String clientFullName;
    private String patientNickname;
    private String problem;
    private String bio;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean scheduled;
}