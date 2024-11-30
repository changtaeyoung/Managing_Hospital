package com.example.managing_hospital.medicalRecord.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class MedicalRecordRequestDTO {

    private String doctorEmail;
    private String patientPhoneNumber;
    private LocalDate visitDate;
    private String diagnosis;
    private String prescription;

}
