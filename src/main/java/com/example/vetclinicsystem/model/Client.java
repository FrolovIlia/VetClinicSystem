package com.example.vetclinicsystem.model;

import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
public class Client {
    @Id
    private String id;
    private String clientFullName;
}