package com.example.managing_hospital.materials.repository;

import com.example.managing_hospital.materials.entity.Materials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MaterialsRepository extends JpaRepository<Materials, UUID> {
    List<Materials> findByName(String name);
    Optional<Materials> findByNameAndPurchaseDate(String name, LocalDate purDate);

}