package com.example.vetclinicsystem.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class MedicalCard {
    @Id
    private String id;
    private String patientNickname;
    private String problem;
    private String bio;
}
