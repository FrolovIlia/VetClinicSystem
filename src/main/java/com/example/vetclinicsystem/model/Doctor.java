package com.example.vetclinicsystem.model;

import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
public class Doctor {
    @Id
    private String doctorId;
    private String doctorFullName;

}
