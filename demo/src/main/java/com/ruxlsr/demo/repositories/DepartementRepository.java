package com.ruxlsr.demo.repositories;

import com.ruxlsr.demo.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DepartementRepository extends JpaRepository<Department, UUID> {
    // Pour eviter les doublons sur les departements en BD
    boolean existsDistinctByLibelleDepartement(String libelleDepartement);
}
