package com.example.vetclinicsystem.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;


@Data
public class DoctorsAppointment {
    @Id
    private String id;
    private String DoctorFullName;
    private String ClientFullName;
    private String PatientNickname;
    private String Problem;
    private String Bio;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean scheduled;
}