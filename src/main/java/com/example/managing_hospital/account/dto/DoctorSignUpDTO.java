package com.example.managing_hospital.account.dto;

import com.example.managing_hospital.account.entity.Doctor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DoctorSignUpDTO {
    private String name;
    private String email;
    private String password;
    private String specialty;

    public Doctor toEntity() {
        Doctor doctor = new Doctor();
        doctor.setName(name);
        doctor.setEmail(email);
        doctor.setPassword(password);
        doctor.setSpecialty(specialty);

        return doctor;
    }
}
