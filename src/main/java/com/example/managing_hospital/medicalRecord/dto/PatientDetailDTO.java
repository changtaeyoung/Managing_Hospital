package com.example.managing_hospital.medicalRecord.dto;

import com.example.managing_hospital.medicalRecord.entity.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class PatientDetailDTO {

    private String patientName;
    private String patientPhoneNumber;
    private LocalDate patientBirthday;
    private Gender patientGender;

}
