package com.example.managing_hospital.hospitalmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/hospitalmanager")
@Controller
public class webController {

    @GetMapping("/hi")
    @ResponseBody
    public String index() {
        return "병원 업무 홈페이지";
    }

    @GetMapping("/medical-records")
    public String medicalRecords() {
    return "medical_records";
    }
}

