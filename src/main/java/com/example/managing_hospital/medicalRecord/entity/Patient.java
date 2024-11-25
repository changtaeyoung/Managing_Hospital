package com.example.managing_hospital.medicalRecord.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
import java.time.LocalDate;

@Getter
@Entity
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String phoneNumber;

    @Column(nullable = false, length = 100)
    private LocalDate birthday;

}