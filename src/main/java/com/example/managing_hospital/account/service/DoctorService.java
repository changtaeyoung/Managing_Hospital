package com.example.managing_hospital.account.service;

import com.example.managing_hospital.account.dto.DoctorSignUpDTO;
import com.example.managing_hospital.account.entity.Doctor;
import com.example.managing_hospital.account.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final PasswordEncoder passwordEncoder;

    public DoctorService(DoctorRepository doctorRepository, PasswordEncoder passwordEncoder) {
        this.doctorRepository = doctorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 이메일 중복 처리
    public boolean isDoctorEmailDuplicate(DoctorSignUpDTO doctorSignUpDTO) {
        Optional<Doctor> checkDoctor = doctorRepository.findByEmail(doctorSignUpDTO.getEmail());
        return checkDoctor.isPresent();
    }

    // 회원가입 처리
    @Transactional
    public Doctor signUp(DoctorSignUpDTO doctorSignUpDTO) {
        if (isDoctorEmailDuplicate(doctorSignUpDTO)) {
            return null;
        }

        Doctor addDoctor = new Doctor();
        addDoctor.setEmail(doctorSignUpDTO.getEmail());
        addDoctor.setPassword(passwordEncoder.encode(doctorSignUpDTO.getPassword()));
        addDoctor.setName(doctorSignUpDTO.getName());
        addDoctor.setSpecialty(doctorSignUpDTO.getSpecialty());

        return doctorRepository.save(addDoctor);
    }

    // 이메일로 의사 정보 조회
    public Doctor getDoctor(String email) {
        return doctorRepository.findByEmail(email).orElse(null);
    }
}
