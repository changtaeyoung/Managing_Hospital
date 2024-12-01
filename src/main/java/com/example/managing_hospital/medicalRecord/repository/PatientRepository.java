package com.example.managing_hospital.medicalRecord.repository;

import com.example.managing_hospital.medicalRecord.entity.MedicalRecord;
import com.example.managing_hospital.medicalRecord.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {

    Optional<Patient> findByPhoneNumber(String phoneNumber);
    List<Patient> findByName(String patientName);
}
