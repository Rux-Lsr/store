package com.ruxlsr.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;
import java.util.UUID;
import java.util.List;

@Entity
@Table(name="postes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Poste {
    @Id
    @GeneratedValue
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotBlank(message="le libelle du poste est obligatoire")
    private nomPoste libellePoste;

    @Column(nullable = false)
    @Min(value=42000, message="Le salaire minimum doit etre au dessus du SMIG")
    private Integer salaireMin;

    @Column(nullable = false)
    @Max(value=1000000, message="le salaire max est de 1 Million")
    private Integer salaireMax;

    @OneToMany(mappedBy = "poste", cascade = CascadeType.ALL)
    private List<Employe> employes;

    @AssertTrue(message = "Le salaire maximum doit être supérieur au salire minimum")
    public boolean isSalaireValide() {
// pour éviter NullPointerException
        if (salaireMin == null || salaireMax == null) return true;
        return salaireMax > salaireMin;
    }
}
