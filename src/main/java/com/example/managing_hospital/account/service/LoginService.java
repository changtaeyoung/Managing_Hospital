package com.example.managing_hospital.account.service;

import com.example.managing_hospital.account.dto.DoctorLoginDTO;
import com.example.managing_hospital.account.dto.NurseLoginDTO;
import com.example.managing_hospital.account.entity.Doctor;
import com.example.managing_hospital.account.entity.Nurse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
    private final DoctorService doctorService;
    private final NurseService nurseService;
    private final PasswordEncoder passwordEncoder;

    public LoginService(DoctorService doctorService, NurseService nurseService
                        , PasswordEncoder passwordEncoder) {
        this.doctorService = doctorService;
        this.nurseService = nurseService;
        this.passwordEncoder = passwordEncoder;
    }

    public Doctor checkDoctorLogin (DoctorLoginDTO doctorLoginDTO) {
        Doctor checkingDoctor = doctorService.getDoctor(doctorLoginDTO.getEmail());
        if (checkingDoctor != null && passwordEncoder.matches(doctorLoginDTO.getPassword(), checkingDoctor.getPassword())) {
            return checkingDoctor;
        }
        return null; //이메일 또는 비밀번호 확인
    }

    public Nurse checkNurseLogin (NurseLoginDTO nurseLoginDTO) {
        Nurse checkingNurse = nurseService.getNurse(nurseLoginDTO.getEmail());
        if (checkingNurse != null && passwordEncoder.matches(nurseLoginDTO.getPassword(), checkingNurse.getPassword())) {
            return checkingNurse;
        }
        return null; //이메일 또는 비밀번호 확인
    }
}
