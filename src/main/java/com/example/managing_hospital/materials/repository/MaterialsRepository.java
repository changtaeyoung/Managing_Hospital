package com.example.managing_hospital.materials.repository;

import com.example.managing_hospital.materials.entity.Materials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface MaterialsRepository extends JpaRepository<Materials, UUID> {
    Optional<Materials> findByName(String name);
    Optional<Materials> findByNameAndPurchaseDate(String name, Date purDate);

}
