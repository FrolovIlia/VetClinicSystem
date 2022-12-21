package com.example.vetclinicsystem.model;

import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
public class Patient {
    @Id
    private String patientId;
    private String patientNickname;
    private String color;
    private String breed;  //порода
    private int age;
}
