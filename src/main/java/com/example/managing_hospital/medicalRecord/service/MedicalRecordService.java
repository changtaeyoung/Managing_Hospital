package com.example.managing_hospital.medicalRecord.service;

import com.example.managing_hospital.account.entity.Doctor;
import com.example.managing_hospital.account.repository.DoctorRepository;
import com.example.managing_hospital.medicalRecord.entity.Patient;
import com.example.managing_hospital.medicalRecord.entity.MedicalRecord;
import com.example.managing_hospital.medicalRecord.repository.MedicalRecordRepository;
import com.example.managing_hospital.medicalRecord.repository.PatientRepository;
import com.example.managing_hospital.medicalRecord.dto.PatientDetailDTO;
import com.example.managing_hospital.medicalRecord.dto.MedicalRecordRequestDTO;
import com.example.managing_hospital.medicalRecord.dto.MedicalRecordResponseDTO;

import lombok.RequiredArgsConstructor;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    // 의료 기록 생성
    public void createMedicalRecord(MedicalRecordRequestDTO request) {
        // 환자와 의사 존재 여부 확인
        Patient patient = patientRepository.findByPhoneNumber(request.getPatientPhoneNumber())
                .orElseThrow(() -> new IllegalArgumentException("환자 정보가 존재하지 않습니다."));
        Doctor doctor = doctorRepository.findByEmail(request.getDoctorEmail())
                .orElseThrow(() -> new IllegalArgumentException("의사 정보가 존재하지 않습니다."));

        // MedicalRecord 인스턴스 생성
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setPatient(patient);
        medicalRecord.setDoctor(doctor);
        medicalRecord.setVisitDate(request.getVisitDate());
        medicalRecord.setDiagnosis(request.getDiagnosis());
        medicalRecord.setPrescription(request.getPrescription());
    
        // 인스턴스를 튜플로서 테이블에 추가하기
        medicalRecord = medicalRecordRepository.save(medicalRecord);

    }

    // 의료 기록 삭제
    public void deleteMedicalRecord(MedicalRecordRequestDTO request) {
        Patient patient = patientRepository.findByPhoneNumber(request.getPatientPhoneNumber())
                .orElseThrow(() -> new IllegalArgumentException("환자 정보가 존재하지 않습니다."));

        MedicalRecord medicalRecord = medicalRecordRepository.findByPatientAndVisitDate(patient, request.getVisitDate())
                .orElseThrow(() -> new IllegalArgumentException("기록이 존재하지 않습니다."));

        medicalRecordRepository.delete(medicalRecord);

    }

    // 의료 기록 수정
    public void updateMedicalRecord(MedicalRecordRequestDTO request) {
        Patient patient = patientRepository.findByPhoneNumber(request.getPatientPhoneNumber())
                .orElseThrow(() -> new IllegalArgumentException("환자 정보가 존재하지 않습니다."));

        MedicalRecord medicalRecord = medicalRecordRepository.findByPatientAndVisitDate(patient, request.getVisitDate())
                .orElseThrow(() -> new IllegalArgumentException("기록이 존재하지 않습니다."));

        medicalRecord.setVisitDate(request.getVisitDate());
        medicalRecord.setDiagnosis(request.getDiagnosis());
        medicalRecord.setPrescription(request.getPrescription());

        medicalRecordRepository.save(medicalRecord);
    }

    // 모든 환자 리스트를 PatientDetailDTO로 변환하여 반환
    public List<PatientDetailDTO> getAllPatients() {
        List<PatientDetailDTO> responseList = new ArrayList<>();
        List<Patient> patients = patientRepository.findAll();
        for (Patient patient : patients) {
            PatientDetailDTO patientDetailDTO = new PatientDetailDTO(
                    patient.getName(),
                    patient.getPhoneNumber(),
                    patient.getBirthday(),
                    patient.getGender()
            );
            responseList.add(patientDetailDTO);
        }
        return responseList;
    }

    // 환자 이름으로 동명이인 환자 리스트 검색
    public List<PatientDetailDTO> findByPatientName(String patientName) {

        /*
        1. 동명이인 리스트를 찾는다.
        2. dto 를 생성해서 dto 리스트에 추가한다
        3. dto를 반환한다.
         */
        List<PatientDetailDTO> responseList = new ArrayList<>();
        List<Patient> patients = patientRepository.findByName(patientName);
        for(Patient patient : patients) {
            PatientDetailDTO patientDetailDTO = new PatientDetailDTO(
                    patient.getName(),
                    patient.getPhoneNumber(),
                    patient.getBirthday(),
                    patient.getGender()
            );
            responseList.add(patientDetailDTO);
        }
        return responseList;

    }

    // 환자 전화번호로 해당 환자의 진료 기록 리스트 검색
    public List<MedicalRecordResponseDTO> findByPatientPhoneNumber(String phoneNumber) {
        /*
        1. 환자와 관련된 진료 기록 리스트를 dto로 변환한다.
        2. dto 리스트에 추가한다.
        3. 리스트를 반환한다.
         */
        Patient patient = patientRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new IllegalArgumentException("환자 정보를 찾을 수 없습니다."));


        List<MedicalRecord> medicalRecords = medicalRecordRepository.findByPatientPhoneNumber(phoneNumber);

        List<MedicalRecordResponseDTO> responseList = new ArrayList<>();
        for (MedicalRecord medicalRecord : medicalRecords) {
            MedicalRecordResponseDTO responseDTO = new MedicalRecordResponseDTO(
                    medicalRecord.getPatient().getName(),
                    medicalRecord.getPatient().getGender(),
                    medicalRecord.getPatient().getBirthday(),
                    medicalRecord.getPatient().getPhoneNumber(),
                    medicalRecord.getDiagnosis(),
                    medicalRecord.getPrescription(),
                    medicalRecord.getVisitDate()
            );
            responseList.add(responseDTO);
        }
        return responseList;
        }

    // 환자 전화번호와 방문 일자로 특정 진료 기록 검색
    public MedicalRecordResponseDTO findMedicalRecord(MedicalRecordRequestDTO request) {
        /*
        1. 진료 기록 찾기
        2. dto로 변환하기
        3. dto 반환하기
         */
        Patient patient = patientRepository.findByPhoneNumber(request.getPatientPhoneNumber())
                .orElseThrow(() -> new IllegalIdentifierException("환자 정보를 찾을 수 없습니다."));

        MedicalRecord medicalRecord = medicalRecordRepository.findByPatientAndVisitDate(patient, request.getVisitDate())
                .orElseThrow(() -> new IllegalArgumentException("진료 기록을 찾을 수 없습니다."));

        return new MedicalRecordResponseDTO(
                medicalRecord.getPatient().getName(),
                medicalRecord.getPatient().getGender(),
                medicalRecord.getPatient().getBirthday(),
                medicalRecord.getPatient().getPhoneNumber(),
                medicalRecord.getDiagnosis(),
                medicalRecord.getPrescription(),
                medicalRecord.getVisitDate()
        );
    }
}



/*
findByPatientName : 환자 이름 -> 동명이인 환자 리스트
findByPatientPhoneNumber : 환자 전화번호 -> 해당 환자의 진료 기록 리스트
findMedicalRecordID : 환자 전화번호, 방문 일자 -> 특정 진료 기록
 */


