package com.example.managing_hospital.account.controller;

import com.example.managing_hospital.account.dto.NurseLoginDTO;
import com.example.managing_hospital.account.dto.NurseSignUpDTO;
import com.example.managing_hospital.account.entity.Nurse;
import com.example.managing_hospital.account.service.LoginService;
import com.example.managing_hospital.account.service.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nurse")
public class NurseController {
    @Autowired
    private NurseService nurseService;
    @Autowired
    private LoginService loginService;

    // 회원가입 처리
    @PostMapping("/signup")
    public ResponseEntity<Nurse> signup(@RequestBody NurseSignUpDTO nurseSignUpDTO) {
        Nurse addNurse = nurseService.signUp(nurseSignUpDTO);
        if (addNurse != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(addNurse);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    // 로그인 처리
    @PostMapping("/login")
    public ResponseEntity<Nurse> login(@RequestBody NurseLoginDTO nurseLoginDTO) {
        Nurse loginCheckNurse = loginService.checkNurseLogin(nurseLoginDTO);
        if (loginCheckNurse != null) {
            return ResponseEntity.status(HttpStatus.OK).body(loginCheckNurse);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

    @PostMapping
    public ResponseEntity<Nurse> getNurse(@RequestParam String email) {
        Nurse loginNurse = nurseService.getNurse(email);
        return ResponseEntity.status(HttpStatus.OK).body(loginNurse);
    }

}
