package com.example.managing_hospital.account.controller;

import com.example.managing_hospital.account.dto.DoctorLoginDTO;
import com.example.managing_hospital.account.dto.DoctorSignUpDTO;
import com.example.managing_hospital.account.entity.Doctor;
import com.example.managing_hospital.account.service.DoctorService;
import com.example.managing_hospital.account.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private LoginService loginService;

    // 회원가입 처리
    @PostMapping("/signup")
    public ResponseEntity<Doctor> signup(@RequestBody DoctorSignUpDTO doctorSignUpDTO) {
        Doctor addDoctor = doctorService.signUp(doctorSignUpDTO);
        if (addDoctor != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(addDoctor);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    //로그인 처리
    @PostMapping("/login")
    public ResponseEntity<Doctor> login(@RequestBody DoctorLoginDTO doctorLoginDTO) {
        Doctor loginCheckDoctor = loginService.checkDoctorLogin(doctorLoginDTO);
        if (loginCheckDoctor != null) {
            return ResponseEntity.status(HttpStatus.OK).body(loginCheckDoctor);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

    // doctor 정보 가져옴
    @PostMapping
    public ResponseEntity<Doctor> getDoctor(@RequestParam String email) {
        Doctor loginDoctor = doctorService.getDoctor(email);
        return ResponseEntity.status(HttpStatus.OK).body(loginDoctor);
    }

}
