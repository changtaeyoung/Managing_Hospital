package com.example.managing_hospital.account.dto;

import com.example.managing_hospital.account.entity.Doctor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class DoctorLoginDTO {
    private String email;
    private String password;

    public Doctor toEntity() {
        Doctor doctor = new Doctor();
        doctor.setEmail(email);
        doctor.setPassword(password);

        return doctor;
    }
}
