package com.example.managing_hospital.medicalRecord.repository;

import com.example.managing_hospital.medicalRecord.entity.MedicalRecord;
import com.example.managing_hospital.medicalRecord.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.time.LocalDate;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, UUID> {
    List<MedicalRecord> findByPatientPhoneNumber(String phoneNumber);
    Optional<MedicalRecord> findByPatientAndVisitDate(Patient patient, LocalDate visitDate);
}
