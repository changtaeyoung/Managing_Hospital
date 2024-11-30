/*
package com.example.managing_hospital.dataLoader;

import com.example.managing_hospital.account.entity.Doctor;
import com.example.managing_hospital.account.repository.DoctorRepository;
import com.example.managing_hospital.medicalRecord.entity.Patient;
import com.example.managing_hospital.medicalRecord.repository.PatientRepository;
import com.example.managing_hospital.medicalRecord.entity.Gender;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(DoctorRepository doctorRepository, PatientRepository patientRepository) {
        return args -> {
            */
/*//*
/ 의사 데이터 추가
            Doctor doctor1 = new Doctor();
            doctor1.setName("John Doe");
            doctor1.setEmail("john.doe@example.com");
            doctor1.setPassword("password123"); // 실제 프로덕션에서는 암호화 필요
            doctor1.setSpecialty("Cardiology");

            Doctor doctor2 = new Doctor();
            doctor2.setName("Jane Smith");
            doctor2.setEmail("jane.smith@example.com");
            doctor2.setPassword("securepass456");
            doctor2.setSpecialty("Neurology");

            doctorRepository.saveAll(List.of(doctor1, doctor2));*//*


            // 환자 데이터 추가
            Patient patient1 = new Patient();
            patient1.setName("Alice Brown");
            patient1.setPhoneNumber("111-111-1111");
            patient1.setBirthday(LocalDate.of(1990, 1, 15));
            patient1.setGender(Gender.Female);

            Patient patient2 = new Patient();
            patient2.setName("Alice Brown");
            patient2.setPhoneNumber("222-222-2222");
            patient2.setBirthday(LocalDate.of(1985, 5, 25));
            patient2.setGender(Gender.Male);

            Patient patient3 = new Patient();
            patient3.setName("Alice Brown");
            patient3.setPhoneNumber("333-333-3333");
            patient3.setBirthday(LocalDate.of(2000, 9, 10));
            patient3.setGender(Gender.Male);

            patientRepository.saveAll(List.of(patient1, patient2, patient3));
        };
    }
}
*/
