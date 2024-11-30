// 테스트를 위한 튜플을 생성

package com.example.managing_hospital.data;

import com.example.managing_hospital.medicalRecord.entity.Patient;
import com.example.managing_hospital.medicalRecord.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private RecordDoctorRepository recordDoctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void run(String... args) throws Exception {
        // 의사 데이터 생성
        Doctor doctor1 = new Doctor();
        doctor1.setName("Dr. Kim");
        doctor1.setEmail("dr.kim@hospital.com");
        doctor1.setPassword("password123");
        doctor1.setSpecialty("Cardiology");
        recordDoctorRepository.save(doctor1);

        Doctor doctor2 = new Doctor();
        doctor2.setName("Dr. Lee");
        doctor2.setEmail("dr.lee@hospital.com");
        doctor2.setPassword("password123");
        doctor2.setSpecialty("Neurology");
        recordDoctorRepository.save(doctor2);

        // 환자 데이터 생성
        Patient patient1 = new Patient();
        patient1.setName("John Doe");
        patient1.setPhoneNumber("010-1234-5678");
        patient1.setBirthday(LocalDate.of(1993, 5, 10));
        patientRepository.save(patient1);

        Patient patient2 = new Patient();
        patient2.setName("Jane Smith");
        patient2.setPhoneNumber("010-9876-5432");
        patient2.setBirthday(LocalDate.of(1997, 8, 20));
        patientRepository.save(patient2);

        Patient patient3 = new Patient();
        patient3.setName("Michael Johnson");
        patient3.setPhoneNumber("010-1112-1314");
        patient3.setBirthday(LocalDate.of(1992, 3, 15));
        patientRepository.save(patient3);
    }
}
