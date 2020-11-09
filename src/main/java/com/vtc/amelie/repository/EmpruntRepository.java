package com.vtc.amelie.repository;

import com.vtc.amelie.model.Emprunt;
import com.vtc.amelie.model.EmpruntDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {
    @Query("SELECT new com.vtc.amelie.model.EmpruntDTO(e.idEmprunt, e.conducteur, e.vehicule) FROM Emprunt e")
    List<EmpruntDTO> findAllEmprunts();
}
