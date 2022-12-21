package com.example.vetclinicsystem.model;

import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
public class Patient {
    @Id
    private String PatientId;
    private String PatientNickname;
    private String Color;
    private String Breed;
    private int Age;
}
