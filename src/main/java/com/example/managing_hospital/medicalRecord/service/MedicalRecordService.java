package com.example.managing_hospital.medicalRecord.service;

import com.example.managing_hospital.medicalRecord.entity.Doctor;
import com.example.managing_hospital.medicalRecord.entity.Patient;
import com.example.managing_hospital.medicalRecord.entity.MedicalRecord;
import com.example.managing_hospital.medicalRecord.repository.RecordDoctorRepository;
import com.example.managing_hospital.medicalRecord.repository.PatientRepository;
import com.example.managing_hospital.medicalRecord.repository.MedicalRecordRepository;
import com.example.managing_hospital.medicalRecord.dto.MedicalRecordRequestDTO;
import com.example.managing_hospital.medicalRecord.dto.MedicalRecordResponseDTO;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;
    private final PatientRepository patientRepository;
    private final RecordDoctorRepository doctorRepository;

    public MedicalRecordResponseDTO createMedicalRecord(MedicalRecordRequestDTO request) {
        // 환자ID와 의사ID 존재 여부 확인
        Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 환자 ID입니다."));
        Doctor doctor = doctorRepository.findById(request.getDoctorId())
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 의사 ID입니다."));

        // MedicalRecord 엔티티 생성 (getter 메소드 사용하여 값 설정)
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setPatient(patient);
        medicalRecord.setDoctor(doctor);
        medicalRecord.setVisitDate(request.getVisitDate());
        medicalRecord.setDiagnosis(request.getDiagnosis());
        medicalRecord.setPrescription(request.getPrescription());

        medicalRecord = medicalRecordRepository.save(medicalRecord);

        return new MedicalRecordResponseDTO(
                medicalRecord.getId(),
                medicalRecord.getPatient().getId(),
                medicalRecord.getDoctor().getId(),
                medicalRecord.getVisitDate(),
                medicalRecord.getDiagnosis(),
                medicalRecord.getPrescription()
        );
    }
}

