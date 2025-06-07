package com.ruxlsr.demo.dto;

import com.ruxlsr.demo.entities.nomPoste;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

import java.util.UUID;

public record EmployeDTO(
        UUID id,
        String nom,
        String email,
        Integer anciennete,
        Integer salaire,
        nomPoste poste,
        String departement
) {
}
