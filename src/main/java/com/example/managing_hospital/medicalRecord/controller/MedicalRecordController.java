package com.example.managing_hospital.medicalRecord.controller;

import com.example.managing_hospital.medicalRecord.dto.MedicalRecordRequestDTO;
import com.example.managing_hospital.medicalRecord.dto.MedicalRecordResponseDTO;
import com.example.managing_hospital.medicalRecord.service.MedicalRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medical-records")
@RequiredArgsConstructor
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;

    @PostMapping
    public ResponseEntity<MedicalRecordResponseDTO> createMedicalRecord(
            @RequestBody MedicalRecordRequestDTO request) {
        MedicalRecordResponseDTO response = medicalRecordService.createMedicalRecord(request);
        return ResponseEntity.ok(response);
    }
}
