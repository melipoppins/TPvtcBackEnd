package com.vtc.amelie.repository;

import com.vtc.amelie.model.Vehicule;
import com.vtc.amelie.model.VehiculeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {
    @Query("SELECT new com.vtc.amelie.model.VehiculeDTO(v.idVehicule, v.marque, v.modele) FROM Vehicule v")
    List<VehiculeDTO> findAllVehicules();
}
