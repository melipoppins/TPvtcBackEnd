package com.vtc.amelie.repository;

import com.vtc.amelie.model.Conducteur;
import com.vtc.amelie.model.ConducteurDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConducteurRepository extends JpaRepository<Conducteur, Long> {
    @Query("SELECT new com.vtc.amelie.model.ConducteurDTO(c.idConducteur, c.nom, c.prenom) FROM Conducteur c")
    List<ConducteurDTO> findAllConducteurs();
}
