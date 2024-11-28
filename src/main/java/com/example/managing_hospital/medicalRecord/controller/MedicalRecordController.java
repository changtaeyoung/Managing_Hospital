package com.example.managing_hospital.medicalRecord.controller;

import com.example.managing_hospital.medicalRecord.dto.PatientDetailDTO;
import com.example.managing_hospital.medicalRecord.dto.MedicalRecordRequestDTO;
import com.example.managing_hospital.medicalRecord.dto.MedicalRecordResponseDTO;
import com.example.managing_hospital.medicalRecord.service.MedicalRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medical-records")
@RequiredArgsConstructor
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;

    @PostMapping("/create")
    public ResponseEntity<String> createMedicalRecord(
            @RequestBody MedicalRecordRequestDTO request) {
        medicalRecordService.createMedicalRecord(request);
        return ResponseEntity.ok("생성되었습니다.");
    }


    @PostMapping("/update")
    public ResponseEntity<String> updateMedicalRecord(
            @RequestBody MedicalRecordRequestDTO request) {
        medicalRecordService.updateMedicalRecord(request);
        return ResponseEntity.ok("수정되었습니다.");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteMedicalRecord(
            @RequestBody MedicalRecordRequestDTO request) {
        medicalRecordService.deleteMedicalRecord(request);
        return ResponseEntity.ok("삭제되었습니다.");
    }

    // 이름으로 환자 리스트 검색
    @GetMapping("/search-patients")
    public ResponseEntity<List<PatientDetailDTO>> findPatientsByName(
            @RequestParam String name) {
        List<PatientDetailDTO> patientsDetailDTOs
                = medicalRecordService.findByPatientName(name);
        return ResponseEntity.ok(patientsDetailDTOs);
    }

    // 환자 전화번호로 특정 환자의 진료 기록 리스트 검색
    @GetMapping("/search-medicalRecords")
    public ResponseEntity<List<MedicalRecordResponseDTO>> findMedicalRecordsByPhoneNumber(
            @RequestParam String phoneNumber) {
        List<MedicalRecordResponseDTO> medicalRecordResponseDTOs
                = medicalRecordService.findByPatientPhoneNumber(phoneNumber);
        return ResponseEntity.ok(medicalRecordResponseDTOs);
    }

    // 환자의 전화번호와 방문일자로 특정 진료 기록 검색
    @GetMapping("/search-medicalRecord")
    public ResponseEntity<MedicalRecordResponseDTO> findMedicalRecord(
            @RequestBody MedicalRecordRequestDTO request) {
        MedicalRecordResponseDTO medicalRecordResponseDTO
                = medicalRecordService.findMedicalRecord(request);
        return ResponseEntity.ok(medicalRecordResponseDTO);
    }

}
