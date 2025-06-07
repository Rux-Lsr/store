package com.ruxlsr.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "departments")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Department {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    @NotBlank(message = "Le libellé du département est obligatoire")
    private String libelleDepartement;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employe> employes;
}
