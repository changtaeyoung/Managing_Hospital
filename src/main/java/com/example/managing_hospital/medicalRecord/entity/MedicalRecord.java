package com.example.managing_hospital.medicalRecord.entity;

import com.example.managing_hospital.account.entity.Doctor;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;


@Getter
@Entity
@NoArgsConstructor
@Setter
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @Column(nullable = false)
    private LocalDate visitDate;

    @Column
    private String diagnosis;

    @Column
    private String prescription;
}
