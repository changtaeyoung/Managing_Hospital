package com.example.managing_hospital.medicalRecord.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class MedicalRecordResponseDTO {

    private UUID id;
    private UUID patientId;
    private UUID doctorId;
    private LocalDate visitDate;
    private String diagnosis;
    private String prescription;
}
