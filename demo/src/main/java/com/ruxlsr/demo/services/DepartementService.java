package com.ruxlsr.demo.services;

import com.ruxlsr.demo.entities.Department;
import com.ruxlsr.demo.repositories.DepartementRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DepartementService {
    private final DepartementRepository departementRepository;

    // Ajouter un nouveau département en BD
    public Department addDepartement(Department departement) {
        return departementRepository.save(departement);
    }

    // Recupérer la liste de tous les postes qui existent dans la BD
    public List<Department> allDepartements() {
        return departementRepository.findAll();
    }

    // Recupérer un poste qui existe dans la BD par son ID
    public Optional<Department> getDepartementById(UUID id) {
        return departementRepository.findById(id);
        }

    // Modifier les informations sur un poste (existingDepartement) dejà existant en BD
    public Department updateDepartement(UUID id, Department updatedDepartement) {
        return departementRepository.findById(id).map(
                existingDepartement->{
                    existingDepartement.setLibelleDepartement(updatedDepartement.getLibelleDepartement());
                    return departementRepository.save(existingDepartement);
                }
        ).orElseThrow(() -> new RuntimeException("Département non trouvé !"));
    }

// Supprimer de la BD un poste par son ID
public void deleteDepartement(UUID id) {
// Si le département a supprimer n'existe pas il faut afficher un message
    if(!departementRepository.existsById(id)) {
        throw new EntityNotFoundException("Le département avec id " + id
                + " n'existe pas !");
    }
    departementRepository.deleteById(id);
}
}
