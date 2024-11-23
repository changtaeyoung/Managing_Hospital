package com.example.managing_hospital.account.service;

import com.example.managing_hospital.account.dto.NurseLoginDTO;
import com.example.managing_hospital.account.dto.NurseSignUpDTO;
import com.example.managing_hospital.account.entity.Nurse;
import com.example.managing_hospital.account.repository.NurseRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NurseService {
    private final NurseRepository nurseRepository;
    private final PasswordEncoder passwordEncoder;

    public NurseService(NurseRepository nurseRepository, PasswordEncoder passwordEncoder) {
        this.nurseRepository = nurseRepository;
        this.passwordEncoder = passwordEncoder;
    }
    // 이메일 중복 처리
    public boolean isNurseEmailDuplicate(NurseSignUpDTO nurseSignUpDTO) {
        Optional<Nurse> checkNurse = nurseRepository.findByEmail(nurseSignUpDTO.getEmail());
        return checkNurse.isPresent();
    }

    // 회원가입 처리
    @Transactional
    public Nurse signUp(NurseSignUpDTO nurseSignUpDTO) {
        if (isNurseEmailDuplicate(nurseSignUpDTO)) {
            return null;
        }

        Nurse addnurse = new Nurse();
        addnurse.setEmail(nurseSignUpDTO.getEmail());
        addnurse.setPassword(passwordEncoder.encode(nurseSignUpDTO.getPassword()));
        addnurse.setName(nurseSignUpDTO.getName());

        return nurseRepository.save(addnurse);
    }

    // 이메일로 의사 정보 조회
    public Nurse getNurse(String email) {
        return nurseRepository.findByEmail(email).orElse(null);
    }
}
