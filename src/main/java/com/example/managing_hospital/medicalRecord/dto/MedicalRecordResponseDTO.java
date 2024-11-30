package com.example.managing_hospital.medicalRecord.dto;

import com.example.managing_hospital.medicalRecord.entity.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class MedicalRecordResponseDTO {

    // 환자 이름, 성별, 생년월일
    private String patientName;
    private Gender gender;
    private LocalDate birthday;
    private String phoneNumber;
    private String diagnosis;
    private String prescription;
    private LocalDate visitDate;
}
