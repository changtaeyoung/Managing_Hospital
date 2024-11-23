package com.example.managing_hospital.account.repository;

import com.example.managing_hospital.account.entity.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface NurseRepository extends JpaRepository<Nurse, UUID> {
    Optional<Nurse> findByEmail(String email);
}
