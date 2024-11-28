package com.example.managing_hospital.hospitalmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class webController {

    @GetMapping("/hospitalmanager")
    @ResponseBody
    public String index() {
        return "병원 업무 홈페이지";
    }
}

